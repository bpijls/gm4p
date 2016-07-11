package games.flappybird;

import gm4p.GM;
import processing.core.PApplet;

public class MainGame extends PApplet {

    public void settings() {
        size(640, 480);
    }

    public void setup() {
        GM.begin(this);
        GM.debugMode = true;
        GM.gamestateManager.addGameState("flappybird_playingState", new games.flappybird.PlayingState());
        GM.gamestateManager.addGameState("flappybird_gameoverState", new games.flappybird.GameOverState());
        GM.gamestateManager.addGameState("flappybird_titleScreenState", new games.flappybird.TitleScreenState());
        GM.gamestateManager.switchTo("flappybird_titleScreenState");
    }

    public void draw() {
        GM.execute();
    }
}

