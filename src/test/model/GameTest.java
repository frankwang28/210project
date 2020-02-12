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

    }

}