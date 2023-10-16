package Junior_java_develop.TASK4;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("text.txt", false)) {
            writer.append("Some info");

            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
