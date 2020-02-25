package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveScore {
    public PrintWriter printWriter;

    public static class Score implements Saveable {
        private String score;

        // EFFECTS:  constructs a score
        public Score(String string) {
            score = string;
        }

        @Override
        public void save(PrintWriter printWriter) {
            printWriter.print(score);
        }
    }

    // EFFECTS: constructs a writer that will write data to file

    public SaveScore(File file) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(file, "UTF-8");
    }

    // MODIFIES: this
    // EFFECTS: writes strings to file
    public void write(Score score) {
        score.save(printWriter);
    }


    // MODIFIES: this
    // EFFECTS: close print writer
    // NOTE: you MUST call this method when you are done writing data!
    public void close() {
        printWriter.close();
    }
}
