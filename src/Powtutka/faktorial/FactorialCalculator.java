package Powtutka.faktorial;

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Факториал отрицательного числа не определен. ");
        } else {
            long factorial = calculateFactorial(n);
            System.out.println("Факториал " + n + " равен " + factorial);
        }
    }

    private static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
