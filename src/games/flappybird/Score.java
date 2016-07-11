package games.flappybird;

import gm4p.GM;
import gm4p.gameobjects.TextGameObject;
import processing.core.PGraphics;

/**
 * Created by bpijls on 13/06/16.
 */
public class Score extends TextGameObject {

    private int scoreValue;

    public Score(){
        super("");
        setScoreValue(0);
        position.x = GM.screen.x/2 - getWidth()/2;
        position.y = 50;
    }

    void addToScoreValue(int additional){
        scoreValue+= additional;
        text = String.format("%d",scoreValue);
    }

    void setScoreValue(int scoreValue){
        this.scoreValue = scoreValue;
        text = String.format("%d", scoreValue);
    }

}
