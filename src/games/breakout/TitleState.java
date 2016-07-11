package games.breakout;

import gm4p.GM;
import gm4p.gameobjects.GameObjectList;
import gm4p.gameobjects.SpriteGameObject;
import gm4p.gameobjects.TextGameObject;
import gm4p.utils.InputHelper;

/**
 * Created by bpijls on 15/06/16.
 */
public class TitleState extends GameObjectList {
    TextGameObject textObject;
    String nextGameState;

    public TitleState(String text, String nextGameState){
        this.add(new SpriteGameObject("breakout_spr_background.png"));
        this.nextGameState = nextGameState;
        textObject = new TextGameObject(text);
        textObject.position.x = GM.screen.x/2-textObject.getWidth()/2;
        textObject.position.y = GM.screen.y/2-textObject.getHeight()/2;
        this.add(textObject);
    }

    @Override
    public void handleInput(InputHelper inputHelper) {
        super.handleInput(inputHelper);
        if (inputHelper.isAnyKeyPressed())
            GM.gamestateManager.switchTo(nextGameState);
    }
}
