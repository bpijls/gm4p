package games.missilecommand;

import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 14/06/16.
 */
public class Explosion extends SpriteGameObject {
    private int detonationDurationMs;

    public Explosion(){
        super("missilecommand_spr_explosion.png");
        this.visible = false;
        this.origin = getCenter();
    }

    void detonate(PVector detonationPosition){
        visible = true;
        detonationDurationMs = 2000;
        this.position = detonationPosition;
    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);
        detonationDurationMs -= elapsedTimeMs;
        if (detonationDurationMs < 0);
            visible = false;
    }
}
