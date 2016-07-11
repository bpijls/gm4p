package games.flappybird;

import gm4p.GM;
import gm4p.gameobjects.GameObject;
import gm4p.gameobjects.GameObjectList;
import gm4p.gameobjects.SpriteGameObject;

public class PlayingState extends GameObjectList {
    Bird bird;
    GameObjectList pipes;
    Score score;

    int spawnCounter = 0;

    public PlayingState() {
        this.add(new SpriteGameObject("flappybird_spr_background.png"));
        bird = new Bird();
        this.add(bird);

        pipes = new GameObjectList();
        this.add(pipes);

        score = new Score();
        this.add(score);

    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        if (spawnCounter++ > 100) {
            pipes.add(new Pipe());
            spawnCounter = 0;
        }

        boolean isGameOver = false;

        int scoreValue = 0;
        for (GameObject pipe : pipes.objects) {
            if (pipe.position.x < bird.position.x)
                scoreValue++;

            if (bird.collidesWith((Pipe) pipe))
                isGameOver = true;
        }
        score.setScoreValue(scoreValue);

        if (bird.position.y > GM.screen.y) {
            isGameOver = true;
        }

        if (isGameOver)
            setGameOver();
    }

    private void setGameOver(){
        bird.reset();
        pipes.objects.clear();
        GM.gamestateManager.switchTo("flappybird_gameoverState");
    }
}
