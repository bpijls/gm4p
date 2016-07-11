package games.breakout;

import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class Brick extends SpriteGameObject {

    public Brick(String assetName, PVector position){
        super(assetName);
        this.position = position.copy();
    }
}
