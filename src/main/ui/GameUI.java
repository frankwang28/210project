package ui;

import model.Game;

import java.util.Scanner;

// the panel in which the game is rendered
public class GameUI {

    public static void start() {
        Scanner input = new Scanner(System.in);
        String command;
        System.out.println("Enter 's' to start game! Once started, press u for up, d for down, and n for nothing.");
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
}
