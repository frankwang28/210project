package model;

// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import persistence.LoadScore;
import persistence.SaveScore;
import ui.GameUI;

import java.io.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Represents a game having a boolean on whether the game is active, a player, and a list of obstacles
public class Game {
    public static String SCORE_FILE;
    public static String highScore;
    public static int score;

    public static SaveScore saveScore;
    public static SaveScore.Score newHighScore;

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public static final int TICK = 1000; // game ticks ever 1000ms (currently)

    public static boolean activeGame = false;           // whether the game is active or not
    public static Player player;                // the object that the player controls
    public static ObstaclesList obstaclesList;  // the list of obstacles that are currently in the game

    public static int obstacleCounter;           // counts the amount of ticks before a new obstacle is created
    public static final int COUNTER = 10;

    static Timer timer;


    // EFFECTS: instantiates the game
    public Game() {
        activeGame = false;
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
        obstacleCounter = COUNTER;
        // timer(TICK);
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
        player.move();
        obstaclesList.update();
        score += 10;
        if (checkCollision()) {
            activeGame = false;
        }
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



}
