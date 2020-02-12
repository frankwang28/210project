package model;

import java.util.Random;
import java.util.*;
import java.awt.geom.RectangularShape;

// represents the list of obstacles active in the game
public class ObstaclesList {
    public static List<Obstacle> obstacleList; // a list of the obstacles
    private static final Random rnd = new Random();

    // creates a list of obstacles
    // EFFECTS: creates a list of obstacles
    public ObstaclesList() {
        obstacleList = new ArrayList<>();
    }

    // EFFECTS: adds an obstacle into the list
    public void addObstacle() {
        Obstacle temp = new Obstacle(Game.WIDTH, rnd.nextInt(Game.HEIGHT + 1));
        obstacleList.add(temp);
        System.out.println("Added an obstacle at " + temp.posX + " , " + temp.posY);
    }

    // EFFECTS: checks for collision of an obstacle and the player
    public static boolean checkCollide(Player player) {
        for (Obstacle obj : obstacleList) {
            int top = obj.posY - Obstacle.height / 2;
            int bot = obj.posY + Obstacle.height / 2;
            int lef = obj.posX - Obstacle.width / 2;
            int rig = obj.posX + Obstacle.width / 2;
            int playerTop = player.ypos - player.height / 2;
            int playerBot = player.ypos + player.height / 2;
            int playerLef = Player.XPOS - player.width / 2;
            int playerRig = Player.XPOS + player.width / 2;
            if ((((top > playerTop) && (playerBot > top)) || ((bot > playerTop) && (playerBot > bot)))
                    && (((lef > playerLef) && (playerRig > lef)) || ((rig > playerLef) && (playerRig > rig)))
            ) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: updates all of the obstacles in the list
    public void update() {
        for (Obstacle obstacle : obstacleList) {
            // obstacleList.get(i).checkAndDelete();
            obstacle.moveObstacle();
        }
    }

    // EFFECTS: prints all the obstacles
    public void printAll() {
        for (Obstacle obstacle : obstacleList) {
            System.out.println("There is an obstacle at " + obstacle.posX + " , " + obstacle.posY);
        }
    }
}
