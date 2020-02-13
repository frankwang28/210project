package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game testGame;
    @BeforeEach
    void runBefore() {
        testGame.createNewGame();
    }

    @Test
    void testConstructor() {
        assertTrue(testGame.activeGame);
        assertEquals(testGame.player.ypos, 400);
        assertEquals(testGame.obstaclesList.obstacleList.size(), 1);
    }

    @Test
    void testCheckCollision() {
        Player testPlayer = new Player(400);
        testGame.obstaclesList.addObstacle();
        testGame.obstaclesList.obstacleList.get(0).posY = 400;
        testGame.obstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2;
        assertTrue(testGame.obstaclesList.checkCollide(testPlayer));
        testGame.obstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + Obstacle.width / 2 + 1;
        assertFalse(testGame.obstaclesList.checkCollide(testPlayer));
    }

    @Test
    void testUpdate() {
        testGame.createNewGame();
        testGame.player.moveDirection = 0;
        testGame.player.move();
        assertEquals(testGame.player.ypos, 400);
        Player testPlayer = new Player(400);
        testGame.obstaclesList.addObstacle();
        testGame.obstaclesList.obstacleList.get(0).posY = 400;
        testGame.obstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2;
        assertTrue(testGame.obstaclesList.checkCollide(testPlayer));
        testGame.update();
        assertFalse(testGame.activeGame);
    }

}