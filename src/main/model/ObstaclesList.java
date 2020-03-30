package model;

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
        Obstacle temp;
        int obstacleLevel = setObstacleLevel(Math.ceil((double)(Game.score + 1) / (double)500));
        temp = switchLevel(obstacleLevel);
        obstacleList.add(temp);
    }

    public Obstacle switchLevel(int a) {
        int h = ThreadLocalRandom.current().nextInt(20, Game.HEIGHT - 20);
        Obstacle temp = new ObstacleLevel1(Game.WIDTH + 60, h);
        switch (a) {
            case 1:
                temp = new ObstacleLevel1(Game.WIDTH + 60, h);
                break;
            case 2:
                temp = new ObstacleLevel2(Game.WIDTH + 60, h);
                break;
            case 3:
                temp = new ObstacleLevel3(Game.WIDTH + 60, h);
                break;
        }
        return temp;
    }

    // EFFECTS: sets the obstacle level
    public int setObstacleLevel(double scoreLevel) {
        int obstacleLevel;
        obstacleLevel = (int)scoreLevel;
        if (scoreLevel > 3) {
            obstacleLevel = 3;
        }
        return ThreadLocalRandom.current().nextInt(1, obstacleLevel + 1);
    }

    // EFFECTS: checks for collision of an obstacle and the player
    public static boolean checkCollide(Player player) {
        for (Obstacle obj : obstacleList) {
            int top = obj.posY - obj.height / 2;
            int bot = obj.posY + obj.height / 2;
            int lef = obj.posX - obj.width / 2;
            int rig = obj.posX + obj.width / 2;
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
        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).moveObstacle();
        }
        if (obstacleList.get(0).checkOutside()) {
            obstacleList.remove(0);
        }
    }


}
