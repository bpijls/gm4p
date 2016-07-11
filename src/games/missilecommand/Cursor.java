package games.missilecommand;

import gm4p.gameobjects.SpriteGameObject;
import gm4p.utils.*;
import processing.core.PVector;

/**
 * Created by bpijls on 13/06/16.
 */
public class Cursor extends SpriteGameObject {

    public Cursor(){
        super("missilecommand_spr_crosshair.png");
        origin = getCenter();
    }

    @Override
    public void handleInput(InputHelper inputHelper){
        position = inputHelper.mousePosition.copy();
    }


}
