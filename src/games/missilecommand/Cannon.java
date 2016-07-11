package games.missilecommand;

import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 14/06/16.
 */
public class Cannon extends SpriteGameObject {
    public Cannon(){
        super("missilecommand_spr_cannon.png");
        origin = new PVector(dimension.y/2, dimension.y/2);
    }
}
