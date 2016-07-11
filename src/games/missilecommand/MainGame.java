package games.missilecommand;

import gm4p.GM;
import processing.core.PApplet;

/**
 * Created by bpijls on 13/06/16.
 */
public class MainGame extends PApplet {
    public void settings() {
        size(800, 600);
    }

    public void setup() {
        GM.begin(this);
        GM.debugMode = true;
        GM.gamestateManager.addGameState("missilecommand_playingState", new games.missilecommand.PlayingState());
        GM.gamestateManager.switchTo("missilecommand_playingState");
    }

    public void draw() {
        try {
            GM.execute();
        }
        catch (Exception e){
            GM.debugMessage(e.getMessage());
        }
    }

}
