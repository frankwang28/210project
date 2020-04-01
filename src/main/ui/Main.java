package ui;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// the main class
public class Main extends JFrame {

    // based of code from Lab 3

    public static Game game;
    private Panel panel;
    public static GameUI gameUi;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        GameUI.hasBeenStarted = false;
        Frame frame = new Frame();
        frame.setTitle("Dodger");
        game = new Game();
        panel = new Panel(game);
        frame.add(panel);
        gameUi = new GameUI(game);
        frame.makeKeyHandler(gameUi);
        frame.addKeyListener(new Frame.KeyHandler());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addTimer(game, panel);
    }


}
