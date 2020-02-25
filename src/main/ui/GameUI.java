package ui;

import model.Game;
import model.Obstacle;
import persistence.LoadScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.Scanner;

import java.util.Timer;
import java.util.TimerTask;

// the panel in which the game is rendered
public class GameUI {

    static Timer one;
    static Timer ten;
    private static String command;

    // MODIFIES: this
    // EFFECTS: processes start and user input
    public static void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 's' to start game! Once started, press u for up, d for down, and n for nothing.");
        System.out.println("High Score: " + Game.highScore);
        while (!Game.activeGame) {
            command = input.next();
            if (command.equals("s")) {
                Game.createNewGame();
            } else {
                System.out.println("Please input 's' to start game!");
            }
        }
        while (Game.activeGame) {
            command = input.next();
            if (command.equals("u")) {
                Game.player.moveDirection = -1;
            }
            if (command.equals("d")) {
                Game.player.moveDirection = 1;
            }
            if (command.equals("n")) {
                Game.player.moveDirection = 0;
            }
        }
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

            Game.update();
            Game.obstacleCounter--;
            if (Game.obstacleCounter == 0) {
                Game.obstaclesList.addObstacle();
                Game.obstacleCounter = Game.COUNTER;
            }

            System.out.println("Player is now at " + Game.player.XPOS + " , " + Game.player.ypos); // temp
            for (Obstacle obstacle : Game.obstaclesList.obstacleList) {
                System.out.println("There is an obstacle at " + obstacle.posX + " , " + obstacle.posY);
            }
            if (!Game.activeGame) {
                System.out.println("You have collided! Game over! Enter any key to exit.");
                System.out.println("Your score was: " + Integer.toString(Game.score));
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
