package Junior_java_develop.TASK8.BufferReader3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[100];

        System.out.println("Write text lines");
        System.out.println("Write <stop> to exit");

        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            if (str[i].equals("stop")) {
                break;
            }
        }

        System.out.println("\nYour file data: ");

        for (int i = 0; i < 100; i++) {
            System.out.println(str[i]);
        }
    }
}
