package Junior_java_develop.TASK8.BufferReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c;

        System.out.println("Write char 'q' - for exeption." );

        do{
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
