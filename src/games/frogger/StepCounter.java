package games.frogger;

import gm4p.gameobjects.TextGameObject;

/**
 * Created by bpijls on 15/06/16.
 */
public class StepCounter extends TextGameObject {
    private int steps;

    public StepCounter(){
        super("0 steps");
        position.x = 50;
        position.y = 50;
    }

    public void setSteps(int steps){
        this.steps = steps;
        text = steps + " steps";
    }

    public void incSteps(int inc){
        this.steps += inc;
        this.setSteps(this.steps);
    }
}
