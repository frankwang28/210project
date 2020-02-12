package model;

// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import ui.GameUI;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

// Represents a game having a boolean on whether the game is active, a player, and a list of obstacles
public class Game {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private static final int TICK = 1000; // game ticks ever 1000ms (currently)

    public static boolean activeGame = false;           // whether the game is active or not
    public static Player player;                // the object that the player controls
    public static ObstaclesList obstaclesList;  // the list of obstacles that are currently in the game

    public static int obstacleCounter;           // counts the amount of ticks before a new obstacle is created
    public static final int COUNTER = 10;

    static Timer timer;

    // Creates a game
    // EFFECTS: creates a player with an obstacle on the left side of the screen
    public Game() {
        GameUI.start();
    }


    // Resets everything in the game
    // MODIFIES: this
    // EFFECTS: resets the game to a state where there is only the player and an obstacle

    public static void createNewGame() {
        activeGame = true;
        player = new Player(HEIGHT / 2);
        obstaclesList = new ObstaclesList();
        obstaclesList.addObstacle();
        obstacleCounter = COUNTER;
        timer(TICK);
    }

    // checks for collision between the player and an obstacle
    // MODIFIES: this
    // EFFECTS: if the obstacle and the player are colliding, return true
    public static boolean checkCollision() {
        return ObstaclesList.checkCollide(player);
    }

    // updates the game
    // MODIFIES: this
    // EFFECTS: updates the player and the obstacles
    public static void update() {
        player.move();
        obstaclesList.update();
        if (checkCollision()) {
            System.out.println("Game Over!");
            activeGame = false;
        }
    }

/*
    // creates a timer that calls update every time
    // EFFECTS: intializes a timer that updates game each TICK
    private void addTimer() {
        Timer timer = new Timer(TICK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                update();
                obstacleCounter--;
                if (obstacleCounter == 0) {
                    obstaclesList.addObstacle();
                    obstacleCounter = COUNTER;
                }
                if (activeGame == false) {
                    timerStop();
                }
            }
        });
    }
*/

    // creates a timer that calls update every time
    // EFFECTS: intializes a timer that updates game each TICK

    public static void timer(int i) {
        timer = new Timer();
        timer.schedule(new TimedTask(),0, i);
    }

    // is the task that is called within the timer
    static class TimedTask extends TimerTask {
        @Override
        public void run() {
            update();
            obstacleCounter--;
            if (obstacleCounter == 0) {
                obstaclesList.addObstacle();
                obstaclesList.printAll();
                obstacleCounter = COUNTER;
            }
            if (!activeGame) {
                timer.cancel();
            }
        }
    }

}
