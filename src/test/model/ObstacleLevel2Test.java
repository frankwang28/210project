package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObstacleLevel2Test {
    private ObstacleLevel2 testObstacle;
    @BeforeEach
    void runBefore() {
        testObstacle = new ObstacleLevel2(Game.WIDTH, 400);
    }

    @Test
    void testConstructor() {
        assertEquals(testObstacle.posX, Game.WIDTH);
        assertEquals(testObstacle.posY, 400);
        assertEquals(testObstacle.deltaX, -6);
        assertEquals(testObstacle.height, 50);
        assertEquals(testObstacle.width, 50);
        assertEquals(testObstacle.obstacleColor, new Color(255, 180, 10));
    }

    @Test
    void testDeltaY() {
        boolean temp = true;
        if (testObstacle.deltaY > 1 || testObstacle.deltaY < -1) {
            temp = false;
        }
        assertTrue(temp);
        testObstacle = new ObstacleLevel2(Game.WIDTH, 0);
        if (testObstacle.deltaY > 1 || testObstacle.deltaY < 0) {
            temp = false;
        }
        assertTrue(temp);
        testObstacle = new ObstacleLevel2(Game.WIDTH, 800);
        if (testObstacle.deltaY > 0 || testObstacle.deltaY < -1) {
            temp = false;
        }
        assertTrue(temp);
    }

    @Test
    void testSetSpeed() {
        testObstacle.deltaX = 0;
        assertEquals(testObstacle.deltaX, 0);
        testObstacle = new ObstacleLevel2(Game.WIDTH, 400);
        boolean temp = true;
        if (testObstacle.deltaY > 1 || testObstacle.deltaY < -1) {
            temp = false;
        }
        assertTrue(temp);
        assertEquals(testObstacle.deltaX, -6);

    }

    @Test
    void testMove() {
        int width = Game.WIDTH;
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 1 * testObstacle.deltaX);
        assertEquals(testObstacle.posY, 400 + 1 * testObstacle.deltaY);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 2 * testObstacle.deltaX);
        assertEquals(testObstacle.posY, 400 + 2 * testObstacle.deltaY);

    }

    @Test
    void testCheckOutside() {
        assertFalse(testObstacle.checkOutside(Game.HEIGHT));
        testObstacle.posX = -61;
        assertTrue(testObstacle.checkOutside(Game.HEIGHT));
        testObstacle.posX = 400;
        assertFalse(testObstacle.checkOutside(Game.HEIGHT));
        testObstacle.posY = -100;
        assertTrue(testObstacle.checkOutside(Game.HEIGHT));
        testObstacle.posY = 900;
        assertTrue(testObstacle.checkOutside(Game.HEIGHT));
    }
}
