package persistence;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LoadScore {

    // EFFECTS: returns the number that is stored in the file; throws
    // IOException if an exception is raised when opening / reading from file
    public static String readScore(File file) throws IOException {
        return Files.readAllLines(file.toPath()).get(0);
    }
}
