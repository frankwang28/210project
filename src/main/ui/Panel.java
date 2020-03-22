package ui;

import model.Game;
import model.Obstacle;
import model.ObstaclesList;
import model.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private Game game;

    private static final String START = "Enter 'S' to start game! Once started, use up and down arrow keys to play.";
    private static final String END = "GAME OVER!\n"
            + "Enter 'S' to play again!";

    // Constructs main window
    // EFFECTS: sets up window in which the paddle ball game will be played
    Panel(Game g) {
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        setBackground(Color.GRAY);
        this.game = g;
    }

    /// !!! change this !!!
    @Override
    protected void paintComponent(Graphics g) {
        if (!game.activeGame) {
            GameUI.loadScore();
            startScreen(g);
        } else {
            super.paintComponent(g);
            drawGame(g);
        }
    }

    // Draws the game
    // MODIFIES: game
    // EFFECTS:  draws the game onto g
    public void drawGame(Graphics g) {
        drawPlayer(g);
        drawObstacle(g);
    }

    // Draw the player
    // MODIFIES: game
    // EFFECTS:  draws the tank onto game
    private void drawPlayer(Graphics game) {
        Player player = Game.getPlayer();
        Color savedCol = game.getColor();
        game.setColor(Player.COLOR);
        game.fillRect(player.XPOS - player.width / 2, player.ypos - player.height / 2,
                player.width, player.height);
        game.setColor(savedCol);
    }

    // Draw the ball
    // MODIFIES: g
    // EFFECTS:  draws the ball onto g
    private void drawObstacle(Graphics g) {
        ObstaclesList obstaclesList = Game.getObstacleList();
        Color savedCol = g.getColor();
        g.setColor(Obstacle.COLOR);
        for (Obstacle obstacle : Game.obstaclesList.obstacleList) {
            g.fillRect(obstacle.posX - obstacle.width / 2, obstacle.posY - obstacle.height / 2,
                    obstacle.width, obstacle.height);
        }
        g.setColor(savedCol);
    }

    // MODIFIES: g
    // EFFECTS:  shows the starting messages
    public void startScreen(Graphics g) {
        game = new Game();
        Color saved = g.getColor();
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(START, g, fm, Game.HEIGHT / 2);
        centreString(GameUI.highScoreMessage(), g, fm, Game.HEIGHT / 2 + 50);
        g.setColor(saved);
    }

    // Centres a string on the screen
    // MODIFIES: g
    // EFFECTS:  centres the string str horizontally onto g at vertical position y
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, y);
    }

}
