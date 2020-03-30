package model;

import java.awt.*;

public class ObstacleLevel2 extends Obstacle {

    int dx = -6;

    public ObstacleLevel2(int x, int y) {
        super(x, y);
        height = 50;
        width = 50;
        obstacleColor = new Color(255, 180, 10);
        setSpeed();
    }

    public void setSpeed() {
        deltaX = dx;
    }
}
