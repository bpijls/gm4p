package games.missilecommand;

import gm4p.*;
import gm4p.gameobjects.*;
import gm4p.utils.InputHelper;
import processing.core.PVector;

/**
 * Created by bpijls on 13/06/16.
 */
public class PlayingState extends GameObjectList {

    Cursor cursor;
    Cannon cannon;
    GameObjectList friendlyMissiles, enemyMissiles;
    Explosion explosion;
    Score score;

    public PlayingState() {
        this.add(new SpriteGameObject("missilecommand_spr_background.png"));
        cursor = new Cursor();
        cannon = new Cannon();
        cannon.setLookatTarget(cursor);

        cannon.position = new PVector(384, 504);

        enemyMissiles = new GameObjectList();
        friendlyMissiles = new GameObjectList();

        for (int iMissile = 0; iMissile < 50; iMissile++)
            enemyMissiles.add(new Missile("missilecommand_spr_dotred.png",
                    new PVector(GM.p.random(0, 800), GM.p.random(-1000, -10)),
                    new PVector(GM.p.random(-3, 3), 10)));


        explosion = new Explosion();
        score = new Score();

        this.add(enemyMissiles);
        this.add(friendlyMissiles);
        this.add(cannon);
        this.add(explosion);
        this.add(cursor);
        this.add(score);
    }

    @Override
    public void handleInput(InputHelper inputHelper) {
        super.handleInput(inputHelper);
        if (inputHelper.rightMouseClicked)
            friendlyMissiles.add(new Missile("missilecommand_spr_dotgreen.png",
                    cannon.position.copy(),
                    PVector.mult(cannon.getAngularDirection(), 30)));
    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        for (GameObject go1 : enemyMissiles.objects) {
            for (GameObject go2 : friendlyMissiles.objects) {

                Missile enemyMissile = (Missile) go1, friendlyMissile = (Missile) go2;

                if (friendlyMissile.collidesWith(enemyMissile)) {
                    explosion.detonate(enemyMissile.position);
                    friendlyMissile.setVisible(false);
                }


                if (explosion.collidesWith(enemyMissile)) {
                    enemyMissile.setVisible(false);
                    score.addToScoreValue(1);
                }
            }
        }
    }
}
