package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObstacleLevel1Test {
    private Obstacle testObstacle;
    @BeforeEach
    void runBefore() {
        testObstacle = new ObstacleLevel1(Game.WIDTH, 400);
    }

    @Test
    void testConstructor() {
        assertEquals(testObstacle.posX, Game.WIDTH);
        assertEquals(testObstacle.posY, 400);
        assertEquals(testObstacle.deltaX, -5);
        assertEquals(testObstacle.height, 40);
        assertEquals(testObstacle.width, 40);
        assertEquals(testObstacle.obstacleColor, new Color(255, 255, 50));
    }

    @Test
    void testSetSpeed() {
        testObstacle.deltaX = 0;
        assertEquals(testObstacle.deltaX, 0);
        testObstacle = new ObstacleLevel1(Game.WIDTH, 400);
        assertEquals(testObstacle.deltaX, -5);
    }

    @Test
    void testMove() {
        int width = Game.WIDTH;
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 1 * testObstacle.deltaX);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 2 * testObstacle.deltaX);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 3 * testObstacle.deltaX);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 4 * testObstacle.deltaX);
    }

    @Test
    void testCheckOutside() {
        assertFalse(testObstacle.checkOutside(Game.HEIGHT));
        testObstacle.posX = -61;
        assertTrue(testObstacle.checkOutside(Game.HEIGHT));
    }
}
