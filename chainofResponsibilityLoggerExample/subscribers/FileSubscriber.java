package chainofResponsibilityLoggerExample.subscribers;

import java.io.FileWriter;
import java.io.IOException;

public class FileSubscriber implements LogSubscriber {

    private final FileWriter fileWriter;

    public FileSubscriber(String filePath) throws IOException {
        fileWriter = new FileWriter(filePath);
    }

    @Override
    public void update(String message) {
        try {
            System.out.println("writing to file: " + message);
            this.fileWriter.write(message + "\n");
            this.fileWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
