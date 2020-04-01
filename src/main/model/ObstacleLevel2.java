package model;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class ObstacleLevel2 extends Obstacle {

    int dx = -6;
    int dy;

    int deltaY;

    public ObstacleLevel2(int x, int y) {
        super(x, y);
        height = 50;
        width = 50;
        obstacleColor = new Color(255, 180, 10);
        if (y > ((Game.HEIGHT / 2) + 150)) {
            dy = ThreadLocalRandom.current().nextInt(-1, 1);
        } else if (y < ((Game.HEIGHT / 2) - 150)) {
            dy = ThreadLocalRandom.current().nextInt(0, 2);
        } else {
            dy = ThreadLocalRandom.current().nextInt(-1, 2);
        }
        setSpeed();
    }

    @Override
    public void setSpeed() {
        deltaX = dx;
        deltaY = dy;
    }

    //moves the obstacle when the game is updated
    // MODIFIES: this
    // EFFECTS: obstacle is moved by dx units
    @Override
    public void moveObstacle() {
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
