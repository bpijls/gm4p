package games.breakout;

import gm4p.gameobjects.TextGameObject;

/**
 * Created by bpijls on 15/06/16.
 */
public class BrickCounter extends TextGameObject {
    private int bricks;

    public BrickCounter(){
        super("" +" bricks left");
        position.x = 50;
        position.y = 50;
    }

    public void setBricks(int bricks){
        this.bricks = bricks;
        text = bricks + " bricks left";
    }

}
