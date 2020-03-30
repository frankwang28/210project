package ui;

import model.Game;
import model.Obstacle;
import model.ObstaclesList;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;

public class Panel extends JPanel {

    private Game game;

    public static final Color PLAYER_COLOR = new Color(0, 220, 10);

    private static final String START = "Enter 'S' to start game! "
            + "Once started, use up and down arrow keys to change direction.";
    private static final String END = "GAME OVER! "
            + "Enter 'S' to play again!";

    // Constructs main window
    // EFFECTS: sets up window in which the paddle ball game will be played
    Panel(Game g) {
        setSize(Game.WIDTH, Game.HEIGHT);
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT - 10)); // no clue why i need the - 10 wtf just visua
        setBackground(Color.GRAY);
        this.game = g;
    }

    /// !!! change this !!!
    @Override
    protected void paintComponent(Graphics g) {
        if (!Game.activeGame && !GameUI.hasBeenStarted) {
            GameUI.loadScore();
            startScreen(g);
        } else if (!Game.activeGame) {
            endScreen(g);
        } else {
            super.paintComponent(g);
            try {
                drawGame(g);
            } catch (ConcurrentModificationException e) {
                int i = 0;
            }
        }
    }

    // Draws the game
    // MODIFIES: game
    // EFFECTS:  draws the game onto g
    public void drawGame(Graphics g) {
        drawPlayer(g);
        drawListOfObstacles(g);
        drawScore(g);
    }

    // Draw the player
    // MODIFIES: game
    // EFFECTS:  draws the tank onto game
    private void drawPlayer(Graphics game) {
        Player player = Game.getPlayer();
        Color savedCol = game.getColor();
        game.setColor(PLAYER_COLOR);
        game.fillRect(Player.XPOS - player.width / 2, player.ypos - player.height / 2,
                player.width, player.height);
        game.setColor(savedCol);
    }

    // Draws the list of balls
    // MODIFIES: g
    // EFFECTS:  draws the entire list of balls onto g
    public void drawListOfObstacles(Graphics g) {
        for (Obstacle obstacle : ObstaclesList.obstacleList) {
            g.setColor(obstacle.obstacleColor);
            drawObstacle(obstacle, g);
        }
    }

    // Draw the ball
    // MODIFIES: g
    // EFFECTS:  draws the ball onto g
    private void drawObstacle(Obstacle o, Graphics g) {
        g.fillRect(o.posX - o.width / 2, o.posY - o.height / 2,
                    o.width, o.height);
    }

    // MODIFIES: g
    // EFFECTS:  shows the starting messages
    private void drawScore(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("Score: " + Game.score, (Game.WIDTH - 160), 60);
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

    public void endScreen(Graphics g) {
        System.out.println();
        Color saved = g.getColor();
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(END, g, fm, Game.HEIGHT / 2);
        centreString(GameUI.highScoreMessage(), g, fm, Game.HEIGHT / 2 + 50);
        g.setColor(saved);
//        for debugging
//        for (Obstacle obj: ObstaclesList.obstacleList) {
//            System.out.println(obj.posX);
//        }
    }

    // Centres a string on the screen
    // MODIFIES: g
    // EFFECTS:  centres the string str horizontally onto g at vertical position y
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (Game.WIDTH - width) / 2, y);
    }

}
