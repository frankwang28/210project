package model;

import java.awt.*;

// represents an obstacle
public abstract class Obstacle {
    public int height;
    public int width;

    public Color obstacleColor;

    public int posX;
    public int posY;
    public int deltaX;

    // Constructs an obstacle
    // EFFECTS: an obstacle is created at coordinates (x,y) moving towards the left with speed 4.0
    public Obstacle(int x, int y) {
        this.posX = x;
        this.posY = y;
    }


    //moves the obstacle when the game is updated
    // MODIFIES: this
    // EFFECTS: obstacle is moved by dx units
    public void moveObstacle() {
        posX = posX + deltaX;
    }

    // returns if the object is outside of the screen
    // EFFECTS: checks if the object is outside screen
    public boolean checkOutside() {
        return ((posX + 60) < 0);
    }

}
