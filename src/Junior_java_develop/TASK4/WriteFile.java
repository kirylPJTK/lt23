package Junior_java_develop.TASK4;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("text.txt", false)) {
            String text = "Hello Gold!";
            writer.write(text);
            writer.append('\n');
            writer.append('E');
            writer.append('\n');
            writer.append(text);
            writer.append("\nHello Kirill");

            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
