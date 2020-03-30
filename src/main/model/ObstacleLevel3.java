package model;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class ObstacleLevel3 extends Obstacle {

    int dx = -8;
    int dy;

    int deltaY;

    public ObstacleLevel3(int x, int y) {
        super(x, y);
        if (y > ((Game.HEIGHT / 2) + 100)) {
            dy = ThreadLocalRandom.current().nextInt(-2, 1);
        } else if (y < ((Game.HEIGHT / 2) - 100)) {
            dy = ThreadLocalRandom.current().nextInt(0, 3);
        } else {
            dy = ThreadLocalRandom.current().nextInt(-2, 3);
        }
        height = 60;
        width = 60;
        obstacleColor = new Color(255, 40, 0);
        setSpeed();
    }

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
    public boolean checkOutside() {
        return (posX < 0 || posY + height > Game.HEIGHT || posY + height < 0);
    }
}
