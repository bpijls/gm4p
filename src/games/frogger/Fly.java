package games.frogger;

import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class Fly extends SpriteGameObject {
    public Fly(){
        super("frogger_spr_fly.png");
        position = new PVector(242, 30);

    }
}
