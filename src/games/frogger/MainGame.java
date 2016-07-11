package games.frogger;

import gm4p.GM;
import processing.core.PApplet;

public class MainGame extends PApplet {

    public void settings() {
        size(520, 300);
    }

    public void setup() {
        GM.begin(this);
        GM.debugMode = true;
        GM.gamestateManager.addGameState("frogger_playingState", new games.frogger.PlayingState());
        GM.gamestateManager.addGameState("frogger_winState", new games.frogger.TitleState("Congratulations", "frogger_playingState"));
        GM.gamestateManager.addGameState("frogger_loseState", new games.frogger.TitleState("You're dead", "frogger_playingState"));
        GM.gamestateManager.switchTo("frogger_titleScreenState");
    }

    public void draw() {
        GM.execute();
    }
}

