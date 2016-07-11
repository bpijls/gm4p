package gm4p.utils;

import gm4p.GM;
import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class InputHelper {

    private PApplet p;
    public PVector mousePosition;

    public InputHelper(PApplet parentApplet) {
        this.p = parentApplet;
        GM.debugMessage("InputHelper created");
        mousePosition = new PVector();
    }

    // Arrays of booleans. One for each key code
    public boolean[] lastFrameKeysDown = new boolean[256];
    public boolean[] keysDown = new boolean[256];
    public boolean[] keysPressed = new boolean[256];
    public boolean[] keysReleased = new boolean[256];

    public boolean leftMouseDown = false;
    public boolean centerMouseDown = false;
    public boolean rightMouseDown = false;

    public boolean lastLeftMouseDown = false;
    public boolean lastCenterMouseDown = false;
    public boolean lastRightMouseDown = false;

    public boolean leftMouseClicked = false;
    public boolean centerMouseClicked = false;
    public boolean rightMouseClicked = false;

    public boolean leftMouseReleased = false;
    public boolean centerMouseReleased = false;
    public boolean rightMouseReleased = false;

    public int lastKeyPressed = 0;

    // Call this method after each update in order to remember
    // which keys were pressed in the last frame
    public void update() {
        mousePosition.x = p.mouseX;
        mousePosition.y = p.mouseY;

        for (int iKey = 0; iKey < keysDown.length; iKey++) {
            if (!lastFrameKeysDown[iKey] && keysDown[iKey])
                keysPressed[iKey] = true;
            else
                keysPressed[iKey] = false;


            if (lastFrameKeysDown[iKey] && !keysDown[iKey])
                keysReleased[iKey] = true;
            else
                keysReleased[iKey] = false;

            lastFrameKeysDown[iKey] = keysDown[iKey];
        }


        leftMouseClicked = !lastLeftMouseDown && leftMouseDown;
        rightMouseClicked = !lastRightMouseDown && rightMouseDown;
        centerMouseClicked = !lastCenterMouseDown && centerMouseDown;

        leftMouseReleased = lastLeftMouseDown && !leftMouseDown;
        rightMouseReleased = lastRightMouseDown && !rightMouseDown;
        centerMouseReleased = lastCenterMouseDown && !centerMouseDown;

        lastLeftMouseDown = leftMouseDown;
        lastRightMouseDown = rightMouseDown;
        lastCenterMouseDown = centerMouseDown;
    }

    public void mouseEvent(MouseEvent event) {

        switch (event.getAction()) {
            case MouseEvent.PRESS:
                mousePressed();
                break;
            case MouseEvent.RELEASE:
                mouseReleased();
                break;
        }

    }

    public void keyEvent(KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.PRESS:
                keyPressed();
                break;
            case KeyEvent.RELEASE:
                keyReleased();
                break;
        }
    }

    //keyPressed is a Processing specific "callback" method
    //that gets called when a key is pressed
    //Set the boolean at the index of "keyCode" to true
    void keyPressed() {
        lastKeyPressed = (p.keyCode == 0) ? p.key : p.keyCode;
        keysDown[lastKeyPressed] = true;

        GM.debugMessage("Pressed key:" + lastKeyPressed);
    }

    //keyPressed is a Processing specific "callback" method
    //that gets called when a key is released
    //Set the boolean at the index of "keyCode" to true
    void keyReleased() {
        keysDown[(p.keyCode == 0) ? p.key : p.keyCode] = false;
        GM.debugMessage("Released key:" + (p.keyCode == 0 ? p.key : p.keyCode));
    }

    void mousePressed() {
        GM.debugMessage("Pressed:" + p.mouseButton);

        leftMouseDown = (p.mouseButton == PApplet.LEFT);
        centerMouseDown = (p.mouseButton == PApplet.CENTER);
        rightMouseDown = (p.mouseButton == PApplet.RIGHT);
    }

    void mouseReleased() {
        GM.debugMessage("Released:" + p.mouseButton);

        leftMouseDown = !(p.mouseButton == PApplet.LEFT);
        centerMouseDown = !(p.mouseButton == PApplet.CENTER);
        rightMouseDown = !(p.mouseButton == PApplet.RIGHT);
    }

    public boolean isAnyKeyPressed(){
        boolean anyKeyPressed = false;

        for (boolean key:keysPressed)
             anyKeyPressed = anyKeyPressed || key;

        return anyKeyPressed;
    }
}
