package model;

import java.util.*;

// represents the list of obstacles active in the game
public class ObstaclesList {
    public List<Obstacle> obstacleList; // a list of the obstacles
    private int gameHeight;
    private int gameWidth;

    private Obstacle temp;
    private ObstacleListManager obstacleListManager;

    // creates a list of obstacles
    // EFFECTS: creates a list of obstacles
    public ObstaclesList(int h, int w) {
        obstacleList = new ArrayList<>();
        gameHeight = h;
        gameWidth = w;
    }

    // EFFECTS: adds an obstacle into the list
    public void addObstacle(int score) {
        obstacleListManager = new ObstacleListManager(score, gameHeight, gameWidth);
        temp =  obstacleListManager.createObstacle();
        obstacleList.add(temp);
    }



    // EFFECTS: updates all of the obstacles in the list
    public void update() {
        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).moveObstacle();
        }
        if (obstacleList.get(0).checkOutside(gameHeight)) {
            obstacleList.remove(0);
        }
    }

}
