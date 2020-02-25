package persistence;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LoadScoreTest {

    @Test
    void testConstructor() {
        LoadScore loadScore = new LoadScore();
        assertEquals(loadScore, loadScore);
    }

    @Test
    void testReadScore1() {
        try {
            String Score = LoadScore.readScore(new File("./data/testHighScore1"));
            assertEquals("1200", Score);
        }
        catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
    @Test
    void testReadScore2() {
        try {
            String Score = LoadScore.readScore(new File("./data/testHighScore2"));
            assertEquals("800", Score);
        }
        catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}
