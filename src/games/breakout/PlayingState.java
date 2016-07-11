package games.breakout;

import gm4p.GM;
import gm4p.gameobjects.*;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class PlayingState extends GameObjectList {

    Paddle paddle;
    Ball ball;
    GameObjectList bricks;
    BrickCounter brickCounter;

    public PlayingState() {

        this.add(new SpriteGameObject("breakout_spr_background.png"));
        paddle = new Paddle();
        this.add(paddle);

        ball = new Ball();
        this.add(ball);

        String asset[] = {"blue", "green", "red", "yellow", "blue"};
        bricks = new GameObjectList();
        this.add(bricks);
        for (int iRow = 0; iRow < 5; iRow++)
            for (int iColumn = 0; iColumn < 9; iColumn++)
                bricks.add(new Brick("breakout_spr_brick_" + asset[iRow] + ".png",
                        new PVector(96 + iColumn * 64, 32 + iRow * 32)));

        brickCounter = new BrickCounter();
        this.add(brickCounter);
    }


    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        if (paddle.collidesWith(ball))
            ball.velocity.y = -ball.velocity.y;

        int visibleBricks = 0;
        for (GameObject brick : bricks.objects) {
            if (((SpriteGameObject) brick).isVisible())
                visibleBricks++;

            if (((SpriteGameObject) brick).collidesWith(ball)) {
                ((SpriteGameObject) brick).setVisible(false);
                ball.velocity.y *= -1;
            }
        }

        brickCounter.setBricks(visibleBricks);
        if (visibleBricks <= 0) {
            ball.reset();
            GM.gamestateManager.switchTo("breakout_winState");
            for (GameObject brick : bricks.objects)
                ((SpriteGameObject) brick).setVisible(true);
        }

        if (ball.position.y > GM.screen.y) {
            ball.reset();
            GM.gamestateManager.switchTo("breakout_loseState");
        }
    }
}
