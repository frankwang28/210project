package model;

import java.awt.*;

// represents an obstacle
public class Obstacle {
    public static int height = 48;
    public static int width = 48;
    public static int dx = -8;

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

    // returns if the object is outisde of the screen
    // EFFECTS: checks if the object is outside screen
    public boolean checkOutside() {
        return (posX < 0);
    }

}
