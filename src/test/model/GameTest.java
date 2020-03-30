package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.LoadScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game testGame;
    @BeforeEach
    void runBefore() {
        testGame.createNewGame();
        testGame.highScore = "1000";
        testGame.SCORE_FILE = "./data/testScores.txt";
    }

    @Test
    void testGame() {
        testGame = new Game();
        assertEquals(testGame.WIDTH, 1200);
        assertEquals(testGame.HEIGHT, 800);
        assertEquals(testGame.TICK, 15);
        assertEquals(testGame.COUNTER, Game.COUNTER);
        assertFalse(testGame.activeGame);

    }

    @Test
    void testSetCounter() {
        testGame.score = 0;
        assertEquals(testGame.setCounter(), 18);
        testGame.score = 100000;
        assertEquals(testGame.setCounter(), 6);
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
        testGame.obstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + testGame.obstaclesList.obstacleList.get(0).width / 2 + 1;
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


    @Test
    void testTestScore() throws FileNotFoundException, UnsupportedEncodingException {
        testGame.score = 100;
        testGame.testScore();
        assertEquals(testGame.highScore, "1000");
        testGame.score = 1500;
        testGame.testScore();
    }

    @Test
    void testGetPlayer() {
        assertEquals(testGame.getPlayer(), testGame.player);
    }

}