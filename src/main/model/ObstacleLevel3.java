package model;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class ObstacleLevel3 extends Obstacle {

    int dx = -8;
    int dy;

    int deltaY;

    public ObstacleLevel3(int x, int y) {
        super(x, y);
        height = 60;
        width = 60;
        obstacleColor = new Color(255, 40, 0);
        setSpeed();
    }

    @Override
    public void setSpeed() {
        if (posY > ((Game.HEIGHT / 2) + 200)) {
            dy = ThreadLocalRandom.current().nextInt(-2, 1);
        } else if (posY < ((Game.HEIGHT / 2) - 200)) {
            dy = ThreadLocalRandom.current().nextInt(0, 3);
        } else {
            dy = ThreadLocalRandom.current().nextInt(0, 1);
        }
        deltaX = dx;
        deltaY = dy;
    }

    //moves the obstacle when the game is updated
    // MODIFIES: this
    // EFFECTS: obstacle is moved by dx units
    @Override
    public void moveObstacle() {
        setSpeed();
        posX = posX + deltaX;
        posY = posY + deltaY;
    }

    // returns if the object is outisde of the screen
    // EFFECTS: checks if the object is outside screen
    @Override
    public boolean checkOutside(int h) {
        return (posX < 0 || posY + height > h || posY + height < 0);
    }
}
