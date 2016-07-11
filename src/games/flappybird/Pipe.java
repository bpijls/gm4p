package games.flappybird;
import processing.core.*;
import gm4p.*;
import gm4p.gameobjects.SpriteGameObject;

class Pipe extends SpriteGameObject {
    public Pipe() {
        super("flappybird_spr_pipe.png");
        origin = getCenter();
        position = new PVector(700, GM.p.random(200, 400));
        velocity.x = -100;
    }
}


