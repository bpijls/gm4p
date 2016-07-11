package games.frogger;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import gm4p.utils.InputHelper;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class Frog extends SpriteGameObject {
    PVector startPosition;
    int steps = 0;

    public Frog(){
        super("frogger_spr_frog.png");
        startPosition = new PVector(GM.screen.x/2 - dimension.x/2, GM.screen.y-dimension.y);
        this.reset();
    }

    @Override
    public void reset() {
        super.reset();
        steps = 0;
        position = startPosition.copy();
    }

    @Override
    public void handleInput(InputHelper inputHelper) {
        super.handleInput(inputHelper);
        if (inputHelper.isAnyKeyPressed()) {
            if (inputHelper.keysPressed[PApplet.LEFT]) this.position.x -= 40;
            if (inputHelper.keysPressed[PApplet.RIGHT]) this.position.x += 40;
            if (inputHelper.keysPressed[PApplet.UP]) this.position.y -= 40;
            if (inputHelper.keysPressed[PApplet.DOWN]) this.position.y += 40;

            this.position.x = PApplet.constrain(this.position.x, 0, GM.screen.x - dimension.x);
            this.position.y = PApplet.constrain(this.position.y, 0, GM.screen.y - dimension.y);
            steps++;
        }
    }

    public int getSteps(){
        return steps;
    }
}
