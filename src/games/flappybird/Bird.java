package games.flappybird;

import gm4p.GM;
import gm4p.gameobjects.SpriteGameObject;
import gm4p.utils.InputHelper;
import processing.core.PVector;

class Bird extends SpriteGameObject {
   PVector startPosition;

   public Bird() {
       super("flappybird_spr_bird.png");
       origin = getCenter();
       startPosition = PVector.div(GM.screen, 2.0f);
       this.reset();
   }

   @Override
   public void update(int elapsedTimeMs) {
       velocity.y += 10;
       setAngularDirection(new PVector(100.0f, velocity.y));
   }

   @Override
   public void handleInput(InputHelper inputHelper) {
       if (inputHelper.keysPressed[' '])
           velocity.y = -150;
   }

   @Override
   public void reset() {
       super.reset();
       position = startPosition.copy();
       velocity.y = 0;
   }

}
