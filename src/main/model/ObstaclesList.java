package model;

import java.util.Random;
import java.util.*;

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
            if (((obj.posY - obj.height - player.height) < player.ypos)
                    && (player.ypos < (obj.posY + obj.height + player.height))
                    && ((obj.posX - obj.width - player.width) < Player.XPOS)
                    && (Player.XPOS < (obj.posX + obj.width + player.width))
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
