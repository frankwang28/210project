package model;


import persistence.SaveScore;
import ui.GameUI;

import java.io.*;

import static java.lang.Integer.parseInt;


// Represents a game having a boolean on whether the game is active, a player, and a list of obstacles
public class Game {
    public static String SCORE_FILE = "./data/highScore";
    public static String highScore;
    public int score;

    public SaveScore saveScore;
    public SaveScore.Score newHighScore;

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public static int TICK = 15; // game ticks ever 1000 / 15 ms

    public boolean activeGame = false;           // whether the game is active or not
    public Player player;                // the object that the player controls
    public ObstaclesList obstaclesList;  // the list of obstacles that are currently in the game

    public int obstacleCounter;           // counts the amount of ticks before a new obstacle is created
    public int counter;

    public static CollisionChecker collisionChecker;

    // EFFECTS: instantiates the game
    public Game() {
        activeGame = false;
    }

    public int setCounter() {
        counter = 18 - (score / 250);
        if (counter < 6) {
            counter = 6;
        }
        return counter;
    }

    // Resets everything in the game
    // MODIFIES: this
    // EFFECTS: resets the game to a state where there is only the player and an obstacle
    public void createNewGame() {
        SCORE_FILE = "./data/highScore";
        activeGame = true;
        player = new Player(HEIGHT / 2);
        score = 0;
        obstaclesList = new ObstaclesList(Game.HEIGHT, Game.WIDTH);
        obstaclesList.addObstacle(score);
        obstacleCounter = setCounter();
    }

    // checks for collision between the player and an obstacle
    // MODIFIES: this
    // EFFECTS: if the obstacle and the player are colliding, return true
    public boolean checkCollision() {
        collisionChecker = new CollisionChecker(player, obstaclesList);
        return collisionChecker.checkCollision();
    }

    // updates the game
    // MODIFIES: this
    // EFFECTS: updates the player and the obstacles
    public void update() {
        if (checkCollision()) {
            activeGame = false;
        }
        player.move(HEIGHT);
        obstaclesList.update();
    }

    // MODIFIES: this
    // EFFECTS:  updates the high score
    public void testScore() throws FileNotFoundException, UnsupportedEncodingException {
        if (score > parseInt(highScore)) {
            saveScore = new SaveScore(new File(SCORE_FILE));
            newHighScore = new SaveScore.Score(Integer.toString(score));
            saveScore.write(newHighScore);
            saveScore.close();
            highScore = Integer.toString(score);
        }
    }

    // EFFECTS: returns the player
    public Player getPlayer() {
        return player;
    }

    //EFFECTS: returns the score
    public int getScore() {
        return score;
    }

}
