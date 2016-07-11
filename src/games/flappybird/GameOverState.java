package games.flappybird;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import gm4p.utils.InputHelper;

public class GameOverState extends SpriteGameObject {
    public GameOverState() {
        super("flappybird_spr_gameover.png");
    }

    @Override
    public void handleInput(InputHelper inputHelper) {
        super.handleInput(inputHelper);
        if (inputHelper.keysPressed[' '])
            GM.gamestateManager.switchTo("flappybird_titleScreenState");
    }
}
