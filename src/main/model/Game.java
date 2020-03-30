package model;


import persistence.SaveScore;
import ui.GameUI;

import java.io.*;


// Represents a game having a boolean on whether the game is active, a player, and a list of obstacles
public class Game {
    public static String SCORE_FILE = "./data/highScore";
    public static String highScore;
    public static int score;

    public static SaveScore saveScore;
    public static SaveScore.Score newHighScore;

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public static final int TICK = 15; // game ticks ever 1000 / 15 ms

    public static boolean activeGame = false;           // whether the game is active or not
    public static Player player;                // the object that the player controls
    public static ObstaclesList obstaclesList;  // the list of obstacles that are currently in the game

    public static int obstacleCounter;           // counts the amount of ticks before a new obstacle is created
    public static int COUNTER;



    // EFFECTS: instantiates the game
    public Game() {
        activeGame = false;
    }

    public static int setCounter() {
        COUNTER = 18 - (score / 250);
        if (COUNTER < 6) {
            COUNTER = 6;
        }
        return COUNTER;
    }

    // Resets everything in the game
    // MODIFIES: this
    // EFFECTS: resets the game to a state where there is only the player and an obstacle
    public static void createNewGame() {
        SCORE_FILE = "./data/highScore";
        activeGame = true;
        player = new Player(HEIGHT / 2);
        score = 0;
        obstaclesList = new ObstaclesList();
        obstaclesList.addObstacle();
        obstacleCounter = setCounter();
        GameUI.one(TICK);
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
        if (checkCollision()) {
            activeGame = false;
        }
        player.move();
        obstaclesList.update();
    }

    public static void testScore() throws FileNotFoundException, UnsupportedEncodingException {
        if (score > Integer.parseInt(highScore)) {
            saveScore = new SaveScore(new File(SCORE_FILE));
            newHighScore = new SaveScore.Score(Integer.toString(score));
            saveScore.write(newHighScore);
            saveScore.close();
            highScore = Integer.toString(score);
        }
    }

    public static Player getPlayer() {
        return player;
    }

}
