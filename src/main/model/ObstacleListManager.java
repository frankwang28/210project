package model;

import java.util.concurrent.ThreadLocalRandom;

public class ObstacleListManager {

    private int score;
    private int max;
    private int xpos;

    public ObstacleListManager(int s, int max, int x) {
        score = s + 1;
        this.max = max;
        xpos = x + 60;
    }

    public Obstacle createObstacle() {
        int obstacleLevel = setObstacleLevel(Math.ceil((double)(score) / (double)500));
        return switchLevel(obstacleLevel);
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

    // EFFECTS: a switch which creates the obstacle at its given level
    public Obstacle switchLevel(int a) {
        int h = ThreadLocalRandom.current().nextInt(20, max - 20 + 1);
        switch (a) {
            case 1:
                return new ObstacleLevel1(xpos, h);
            case 2:
                return new ObstacleLevel2(xpos, h);
            case 3:
                return new ObstacleLevel3(xpos, h);
        }
        return new ObstacleLevel1(xpos, h);
    }

}
