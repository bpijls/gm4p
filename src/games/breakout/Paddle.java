package games.breakout;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import gm4p.utils.InputHelper;
import processing.core.PApplet;

/**
 * Created by bpijls on 15/06/16.
 */
public class Paddle extends SpriteGameObject {

    public Paddle(){
        super("breakout_spr_paddle.png");
        origin = getCenter();
        position.x = GM.screen.x / 2 ;
        position.y = GM.screen.y - dimension.y;
    }

    @Override
    public void handleInput(InputHelper inputHelper) {
        super.handleInput(inputHelper);
        position.x = inputHelper.mousePosition.x;
        position.x = PApplet.constrain(position.x, dimension.x/2, GM.screen.x-dimension.x/2);
    }
}
