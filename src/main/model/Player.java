package model;

import java.awt.*;

// represents that player
public class Player {
    public static final int XPOS = 60;

    public int height = 60;
    public int width = 60;
    public int dy = 4;

    public int ypos;
    public int moveDirection = 1;

    //creates a player
    // EFFECTS: places a player at (XPOS, y)
    public Player(int y) {
        this.ypos = y;
    }

    // makes sure the player is still in bounds
    // MODIFIES: this
    // EFFECTS: keeps the player within the boundaries of the game
    public void stayInBounds() {
        if ((ypos + height / 2) > Game.HEIGHT) {
            ypos = (Game.HEIGHT - height / 2);
        } else if ((ypos - height / 2) < 0) {
            ypos = (height / 2);
        }
    }

    // moves the player up, down, or not at all
    // MODIFIES: this
    // EFFECTS: moves the player in the direction
    public void move() {
        this.ypos += (dy * moveDirection);
        stayInBounds();
    }

}
