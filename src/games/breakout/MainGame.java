package games.breakout;

import gm4p.GM;
import processing.core.PApplet;

public class MainGame extends PApplet {

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        GM.begin(this);
        GM.debugMode = true;
        GM.gamestateManager.addGameState("breakout_playingState", new PlayingState());
        GM.gamestateManager.addGameState("breakout_loseState", new TitleState("You're dead", "breakout_playingState"));
        GM.gamestateManager.addGameState("breakout_winState", new TitleState("Congratulations", "breakout_playingState"));
        GM.gamestateManager.switchTo("breakout_playingState");
    }

    public void draw() {
        GM.execute();
    }
}

