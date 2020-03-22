package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstacleTest {
    private Obstacle testObstacle;
    @BeforeEach
    void runBefore() {
        testObstacle = new Obstacle(Game.WIDTH, 400);
    }

    @Test
    void testConstructor() {
        assertEquals(testObstacle.posX, Game.WIDTH);
        assertEquals(testObstacle.posY, 400);
    }

    @Test
    void testMove() {
        int width = Game.WIDTH;
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 1 * testObstacle.dx);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 2 * testObstacle.dx);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 3 * testObstacle.dx);
        testObstacle.moveObstacle();
        assertEquals(testObstacle.posX, width + 4 * testObstacle.dx);
    }

    @Test
    void testCheckOutside() {
        assertFalse(testObstacle.checkOutside());
        testObstacle.posX = -1;
        assertTrue(testObstacle.checkOutside());
    }
}
