package games.frogger;

import gm4p.GM;
import gm4p.gameobjects.*;
import gm4p.gameobjects.GameObjectList;
import gm4p.gameobjects.SpriteGameObject;
import processing.core.PVector;

/**
 * Created by bpijls on 15/06/16.
 */
public class PlayingState extends GameObjectList {

    Frog frog;
    GameObjectList cars;
    Fly fly;
    StepCounter stepCounter;

    public PlayingState() {
        this.add(new SpriteGameObject("frogger_spr_background.png"));
        frog = new Frog();
        this.add(frog);

        fly = new Fly();
        this.add(fly);

        cars = new GameObjectList();
        this.add(cars);
        String assets[] = {"frogger_spr_truck.png", "frogger_spr_racecar.png", "frogger_spr_dozer.png"};
        float velocities[] = {50, -50, 50};

        for (int iRow = 0; iRow < 3; iRow++)
            for (int iCar = 0; iCar < 3; iCar++)
                cars.add(new Car(assets[iRow], new PVector(70 + iCar * 150, 225 - iRow * 40), velocities[iRow]));

        stepCounter = new StepCounter();
        this.add(stepCounter);

    }

    @Override
    public void update(int elapsedTimeMs) {
        super.update(elapsedTimeMs);

        stepCounter.setSteps(frog.getSteps());

        for (GameObject car : cars.objects) {
            if (((SpriteGameObject) car).collidesWith(frog)) {
                GM.gamestateManager.switchTo("frogger_loseState");
                frog.reset();
            }
        }

        if (frog.collidesWith(fly)) {
            GM.gamestateManager.switchTo("frogger_winState");
            frog.reset();
        }
    }
}
