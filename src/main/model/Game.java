package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a game having a boolean on whether the game is active, a player, and a list of obstacles
public class Game {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private static final int TICK = 1000; // game ticks ever 1000ms (currently)

    private boolean activeGame = false;           // whether the game is active or not
    private Player player;                // the object that the player controls
    private ObstaclesList obstaclesList;  // the list of obstacles that are currently in the game
    private Timer timer;                  // creates a new timer

    public int obstacleCounter;           // counts the amount of ticks before a new obstacle is created
    public static final int COUNTER = 10;

    // Creates a game
    // EFFECTS: creates a player with an obstacle on the left side of the screen
    public Game() {
        createNewGame();
    }

    // Resets everything in the game
    // MODIFIES: this
    // EFFECTS: resets the game to a state where there is only the player and an obstacle
    public void createNewGame() {
        activeGame = true;
        player = new Player(HEIGHT / 2);
        obstaclesList = new ObstaclesList();
        obstacleCounter = COUNTER;
        timerStart();
    }

    // checks for collision between the player and an obstacle
    // MODIFIES: this
    // EFFECTS: if the obstacle and the player are colliding, return true
    public boolean checkCollision() {
        if (ObstaclesList.checkCollide(player)) {
            return true;
        } else {
            return false;
        }
    }

    // updates the game
    // MODIFIES: this
    // EFFECTS: updates the player and the obstacles
    public void update() {
        player.move();
        obstaclesList.update();
        if (checkCollision()) {
            System.out.println("Game Over!");
            activeGame = false;
        }
    }

    // creates a timer that calls update every time
    // EFFECTS: intializes a timer that updates game each TICK
    private void addTimer() {
        timer = new Timer(TICK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                obstacleCounter--;
                if (obstacleCounter == 0) {
                    obstaclesList.addObstacle();
                }
                if (activeGame == false) {
                    timerStop();
                }
            }
        });

    }

    // EFFECTS: starts a timer
    private void timerStart() {
        addTimer();
        timer.start();
    }

    // EFFECTS: stops the timer
    private void timerStop() {
        timer.stop();
    }
}
