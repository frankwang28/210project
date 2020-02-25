package persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SaveScoreTest {
    private static final String TEST_FILE = "./data/testScores.txt";
    private SaveScore testSave;
    private SaveScore.Score newHighScore;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testSave = new SaveScore(new File(TEST_FILE));
        newHighScore = new SaveScore.Score("1000");
    }

    @Test
    void testSaveScore() {
        testSave.write(newHighScore);
        testSave.close();

        try {
            String score = LoadScore.readScore(new File(TEST_FILE));
            assertEquals("1000", score);
        } catch(IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}