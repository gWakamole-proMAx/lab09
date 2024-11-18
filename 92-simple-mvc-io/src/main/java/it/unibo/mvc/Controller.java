package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_PATH = "output.txt";

    private File currentFile = new File(HOME + System.getProperty("file.separator") + DEFAULT_PATH);

    /**
     * Set the current file.
     * @param newFile
     */
    public void setCurrentFile(final File newFile) {
        final File parent = newFile.getParentFile();
        if (parent.exists()) {
            currentFile = newFile;
        } else {
            throw new IllegalArgumentException("folder does not exist");
        }
    }

    /**
     * Returns the current file.
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Retruns the current file path.
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return this.currentFile.getPath();
    }

    /**
     * Writes the String paramter into the current file.
     * @param line
     * @throws IOException
     */
    public void writeOnFile(final String line) throws IOException {
        try (PrintStream out = new PrintStream(this.currentFile, StandardCharsets.UTF_8)) {
            out.println(line);
        }
    }
}
