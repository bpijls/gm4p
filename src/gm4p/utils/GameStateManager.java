package gm4p.utils;

import java.util.HashMap;

import gm4p.GM;
import gm4p.gameobjects.GameObject;
import processing.core.*;

public class GameStateManager {
    private PApplet p;
    private HashMap<String, GameObject> gameStates;
    public GameObject activeGameState;

    public GameStateManager(PApplet applet) {
        p = applet;
        gameStates = new HashMap<>();

        GM.debugMessage("AssetManager created");
    }


    public void addGameState(String gameStateName, GameObject gameState) {
        gameStates.put(gameStateName, gameState);
        if (gameStates.size() == 1)
            activeGameState = gameState;
    }

    public void switchTo(String stateName) {
        if (gameStates.containsKey(stateName))
            activeGameState = gameStates.get(stateName);
    }
}
