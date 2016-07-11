package games.missilecommand;

import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 14/06/16.
 */
public class Missile extends SpriteGameObject {
    public Missile(String missileAsset, PVector startPosition, PVector startVelocity){
        super(missileAsset);
        origin = getCenter();
        this.position = startPosition;
        this.velocity = startVelocity;
    }
}
