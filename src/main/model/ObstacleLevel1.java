package model;

import java.awt.*;

public class ObstacleLevel1 extends Obstacle {

    int dx = -5;

    public ObstacleLevel1(int x, int y) {
        super(x, y);
        height = 40;
        width = 40;
        obstacleColor = new Color(255, 255, 50);
        setSpeed();
    }

    public void setSpeed() {
        deltaX = dx;
    }

}
