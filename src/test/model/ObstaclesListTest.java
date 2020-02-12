package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesListTest {
    private ObstaclesList testObstaclesList;
    @BeforeEach
    void runBefore() {
        testObstaclesList = new ObstaclesList();
    }

    @Test
    void testConstructor() {
        assertEquals(testObstaclesList.obstacleList.size(), 0);
    }

    @Test
    void testAddObstacle() {
        testObstaclesList.addObstacle();
        assertEquals(testObstaclesList.obstacleList.size(), 1);
        assertEquals(testObstaclesList.obstacleList.get(0).posX, Game.WIDTH);
        testObstaclesList.addObstacle();
        assertEquals(testObstaclesList.obstacleList.size(), 2);
        assertEquals(testObstaclesList.obstacleList.get(1).posX, Game.WIDTH);
        testObstaclesList.addObstacle();
    }

    @Test
    void testCheckCollide() {

    }

    @Test
    void testUpdate() {

    }
}
