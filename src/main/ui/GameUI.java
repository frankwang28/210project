package ui;

import model.Game;

import persistence.LoadScore;

import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;

// the panel in which the game is rendered
public class GameUI extends JPanel {

    static Timer one;
    private static String command;
    private static Game game;
    private Panel panel;

    public static boolean hasBeenStarted = false;

    // Constructs a game panel
    // EFFECTS:  sets size and background colour of panel,
    //  updates this with the game to be displayed
    GameUI() {
        game = new Game();
        panel = new Panel(game);
        add(panel);
    }

    // Responds to key press codes
    // MODIFIES: this
    // EFFECTS: controls the player
    public void keyPressed(int kcode) {
        if (kcode == KeyEvent.VK_S && !game.activeGame) {
            game.activeGame = true;
            hasBeenStarted = true;
            start();
        } else if (game.activeGame) {
            playerControl(kcode);
        }
    }

    // Controls the player
    // MODIFIES: this
    // EFFECTS: changes direction of paddle in response to key code
    private void playerControl(int kcode) {
        if (kcode == KeyEvent.VK_KP_UP || kcode == KeyEvent.VK_UP) {
            Game.player.moveDirection = -1;
        } else if (kcode == KeyEvent.VK_KP_DOWN || kcode == KeyEvent.VK_DOWN) {
            Game.player.moveDirection = 1;
        }
    }

    // EFFECTS: returns a high score message
    public static String highScoreMessage() {
        String temp;
        if (Game.score > Integer.parseInt(Game.highScore)) {
            return "High Score: " + Game.score;
        }
        return "High Score: " + Game.highScore;
    }

    // MODIFIES: this
    // EFFECTS: processes start and user input
    public static void start() {
        game.createNewGame();
    }

    // creates a timer that calls update every time
    // EFFECTS: initialises a timer that updates game each TICK

    public static void one(int i) {
        one = new Timer();
        one.schedule(new OneTask(),0, i);
    }

    // is the task that is called within the timer
    static class OneTask extends TimerTask {
        @Override
        public void run() {

            Game.obstacleCounter--;
            if (Game.obstacleCounter == 0) {
                Game.obstaclesList.addObstacle();
                Game.obstacleCounter = Game.COUNTER;
                Game.score += 10;
            }
            if (!Game.activeGame) {
                try {
                    Game.testScore();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                one.cancel();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS:  gets the score from SCORE_FILE

    public static void loadScore() {
        try {
            Game.highScore = LoadScore.readScore(new File(Game.SCORE_FILE));
        } catch (IOException e) {
            init();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    public static void init() {
        Game.highScore = "0";
    }

}
