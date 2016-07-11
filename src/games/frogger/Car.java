package games.frogger;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class Car extends SpriteGameObject{
    public Car(String assetName, PVector startPosition, float xVelocity){
        super(assetName);
        this.position = startPosition.copy();
        this.velocity.x = xVelocity;
    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        if (position.x < -dimension.x) position.x = GM.screen.x;
        if (position.x > GM.screen.x) position.x = -dimension.x;
    }
}
