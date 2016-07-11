package games.breakout;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class Ball extends SpriteGameObject {
    public Ball(){
        super("breakout_spr_ball.png");
        reset();
    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        if (position.x < 0) velocity.x = -velocity.x;
        if (position.x > GM.screen.x-dimension.x) velocity.x = -velocity.x;
        if (position.y < 0) velocity.y = -velocity.y;

    }

    @Override
    public void reset(){
        super.reset();
        position = PVector.sub(PVector.div(GM.screen,2), getCenter());
        velocity = new PVector(30, 60);
    }
}
