package DecoratorPatternFileSystem;

import java.io.FileWriter;
import java.io.IOException;

public class Filewriter implements Writer {

    String filePath;

    Filewriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String text) {
        try {
            System.out.println("Writing  into to a file");
            FileWriter fWriter = new FileWriter(
                    filePath);
            fWriter.write(text);
            System.out.println(text);
            // Closing the file writing connection
            fWriter.close();
            // Display message for successful execution of
            // program on the console
            System.out.println(
                    "File is created successfully with the content.");
        } catch (IOException e) {
            System.out.println("Exception occured while writing to file");
        }
    }
}
