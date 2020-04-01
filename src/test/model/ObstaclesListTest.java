package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesListTest {
    private ObstaclesList testObstaclesList;
    @BeforeEach
    void runBefore() {
        testObstaclesList = new ObstaclesList(Game.HEIGHT, Game.WIDTH);
    }

    @Test
    void testConstructor() {
        assertEquals(ObstaclesList.obstacleList.size(), 0);
    }

    @Test
    void testAddObstacle() {
        testObstaclesList.addObstacle(0);
        assertEquals(testObstaclesList.obstacleList.size(), 1);
        assertEquals(testObstaclesList.obstacleList.get(0).posX, Game.WIDTH + 60);
        testObstaclesList.addObstacle(0);
        assertEquals(testObstaclesList.obstacleList.size(), 2);
        assertEquals(testObstaclesList.obstacleList.get(1).posX, Game.WIDTH + 60);
        testObstaclesList.addObstacle(0);
    }



    @Test
    void testUpdate() {
        testObstaclesList.addObstacle(0);
        testObstaclesList.addObstacle(0);
        testObstaclesList.addObstacle(0);
        ObstaclesList.obstacleList.get(0).posY = 123;
        ObstaclesList.obstacleList.get(0).posX = -100;
        ObstaclesList.obstacleList.get(1).posY = 400;
        ObstaclesList.obstacleList.get(1).posX = 200;
        ObstaclesList.obstacleList.get(2).posY = 500;
        ObstaclesList.obstacleList.get(2).posX = 300;
        testObstaclesList.update();
        assertEquals(ObstaclesList.obstacleList.get(0).posY, 400);
        assertEquals(ObstaclesList.obstacleList.get(1).posY, 500);
        assertEquals(ObstaclesList.obstacleList.get(0).posX, 200 + ObstaclesList.obstacleList.get(0).deltaX);
        assertEquals(ObstaclesList.obstacleList.get(1).posX, 300 + ObstaclesList.obstacleList.get(0).deltaX);
    }
}
