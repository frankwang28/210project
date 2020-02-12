package model;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.*;

// represents the list of obstacles active in the game
public class ObstaclesList {
    public static List<Obstacle> obstacleList; // a list of the obstacles
    private static final Random rnd = new Random();

    // creates a list of obstacles
    // EFFECTS: creates a list of obstacles
    public ObstaclesList() {
        obstacleList = new ArrayList<Obstacle>();
    }

    // EFFECTS: adds an obstacle into the list
    public void addObstacle() {
        obstacleList.add(new Obstacle(Game.WIDTH, rnd.nextInt(Game.HEIGHT + 1)));
    }

    public static boolean checkCollide(Player player) {
        for (int i = 0; i < obstacleList.size(); i++) {
            Obstacle obj = obstacleList.get(i);
            if (((obj.posY - obj.height - player.height) < player.ypos)
                    && (player.ypos < (obj.posY + obj.height + player.height))
                    && ((obj.posX - obj.width - player.width) < player.XPOS)
                    && (player.XPOS < (obj.posX + obj.width + player.width))
            ) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: updates all of the obstacles in the list
    public void update() {
        for (int i = 0; i < obstacleList.size(); i++) {
            // obstacleList.get(i).checkAndDelete();
            obstacleList.get(i).moveObstacle();
        }
    }
}
