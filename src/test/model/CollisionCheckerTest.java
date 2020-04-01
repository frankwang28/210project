package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollisionCheckerTest {

    private CollisionChecker testCollisionChecker;
    private ObstaclesList testObstaclesList;
    private Player testPlayer;

    @BeforeEach
    void runBefore() {
        testObstaclesList = new ObstaclesList(Game.HEIGHT, Game.WIDTH);
    }
//
//    @Test
//    void testConstructor() {
//        testPlayer = new Player(400);
//        testObstaclesList.addObstacle();
//        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
//        assertEquals(testPlayer, CollisionChecker.);
//    }

    @Test
    void testCheckCollide() {
        testPlayer = new Player(400);
        testObstaclesList.addObstacle(0);
        testObstaclesList.obstacleList.get(0).posY = 400;
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertTrue(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + testObstaclesList.obstacleList.get(0).width / 2 + 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + testObstaclesList.obstacleList.get(0).width / 2;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + testObstaclesList.obstacleList.get(0).width / 2 - 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertTrue(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - testObstaclesList.obstacleList.get(0).width / 2 - 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - testObstaclesList.obstacleList.get(0).width / 2;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - testObstaclesList.obstacleList.get(0).width / 2 + 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertTrue(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + testObstaclesList.obstacleList.get(0).height / 2 + 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + testObstaclesList.obstacleList.get(0).height / 2;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + testObstaclesList.obstacleList.get(0).height / 2 - 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertTrue(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - testObstaclesList.obstacleList.get(0).height / 2 - 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - testObstaclesList.obstacleList.get(0).height / 2;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertFalse(testCollisionChecker.checkCollision());
        testObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - testObstaclesList.obstacleList.get(0).height / 2 + 1;
        testCollisionChecker = new CollisionChecker(testPlayer, testObstaclesList);
        assertTrue(testCollisionChecker.checkCollision());
    }
}
