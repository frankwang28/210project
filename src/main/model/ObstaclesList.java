package model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

// represents the list of obstacles active in the game
public class ObstaclesList {
    public static List<Obstacle> obstacleList; // a list of the obstacles

    // creates a list of obstacles
    // EFFECTS: creates a list of obstacles
    public ObstaclesList() {
        obstacleList = new ArrayList<>();
    }

    // EFFECTS: adds an obstacle into the list
    public void addObstacle() {
        Obstacle temp = new Obstacle(Game.WIDTH,
                ThreadLocalRandom.current().nextInt(5, Game.HEIGHT - 5));
        obstacleList.add(temp);
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
        List<Integer> temp = new ArrayList();
        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).moveObstacle();
            if (obstacleList.get(i).checkOutside()) {
                temp.add(i);
            }
        }
        for (int i: temp) {
            obstacleList.remove(i);
        }
    }


}
