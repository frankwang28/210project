package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstacleListManagerTest {

    private ObstacleListManager obstacleListManager;

    @BeforeEach
    void runBefore() {
        obstacleListManager = new ObstacleListManager(0, Game.HEIGHT, Game.WIDTH);
    }

    @Test
    void testCreateObstacle() {
        assertEquals(obstacleListManager.createObstacle().width, 40);
    }

    @Test
    void testSetObstacleLevel() {
        assertEquals(obstacleListManager.setObstacleLevel(1), 1);
        boolean test = true;
        if (obstacleListManager.setObstacleLevel(2) < 3) {
            test = false;
        }
        assertFalse(test);
        test = true;
        if (obstacleListManager.setObstacleLevel(3) < 4) {
            test = false;
        }
        assertFalse(test);
        test = true;
        if (obstacleListManager.setObstacleLevel(100) < 4) {
            test = false;
        }
        assertFalse(test);
    }

    @Test
    void testSwitchLevel() {
        assertEquals(obstacleListManager.switchLevel(1).width, 40);
        assertEquals(obstacleListManager.switchLevel(2).width, 50);
        assertEquals(obstacleListManager.switchLevel(3).width, 60);
        assertEquals(obstacleListManager.switchLevel(4).width, 40);
    }

}
