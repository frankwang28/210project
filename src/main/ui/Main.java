package ui;

import model.Game;

// the main class
public class Main {

    // based of code from Lab 3

    public static Game game;
    public static GameUI gameUi;
    public static Frame frame;
    public static Panel panel;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        frame = new Frame();
        frame.setTitle("Dodger");
        game = new Game();
        panel = new Panel(game);
        frame.add(panel);
        gameUi = new GameUI(game);
        GameUI.hasBeenStarted = false;
        frame.addKeyListener(new Frame.KeyHandler());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addTimer(game, panel);
    }


}
