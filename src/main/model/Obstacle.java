package model;

import java.awt.*;

// represents an obstacle
public class Obstacle {
    public static int height = 48;
    public static int width = 48;
    public static int dx = -8;

    public static final Color COLOR = new Color(10, 50, 188);

    public int posX;
    public int posY;
    private int deltaX;

    // Constructs an obstacle
    // EFFECTS: an obstacle is created at coordinates (x,y) moving towards the left with speed 4.0
    public Obstacle(int x, int y) {
        this.posX = x;
        this.posY = y;
        deltaX = dx;
    }

    //moves the obstacle when the game is updated
    // MODIFIES: this
    // EFFECTS: obstacle is moved by dx units
    public void moveObstacle() {
        posX = posX + deltaX;
    }

}
