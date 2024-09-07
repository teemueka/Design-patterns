import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;
    private File file;
    private FileWriter writer;

    private Logger() {
        this.file = new File("log.txt");
        try {
            this.writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException("Logger initialization failed, " + e.getMessage());
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void write(String message) {
        try {
            writer.write(message);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Writing error occurred, " + e.getMessage());
        }

    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
            instance = null;
        } catch (IOException e) {
            throw new RuntimeException("Closing error occurred, " + e.getMessage());
        }
    }

    public synchronized void setFileName(String fileName) {
        try {
            if (writer != null) {
                writer.close();
            }
            this.file = new File(fileName);
            this.writer = new FileWriter(this.file, true);
        } catch (IOException e) {
            throw new RuntimeException("File naming error occurred, " + e.getMessage());
        }
    }

}
