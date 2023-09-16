package Powtutka.Stream;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .filter(n -> n % 3 == 0)
                .forEach(System.out::println );
    }
}
