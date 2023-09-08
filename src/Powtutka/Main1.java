package Powtutka;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        do {
            System.out.println("Введите первое число: ");
            num1 = scanner.nextInt();
            System.out.println("Введите второе число: ");
            num2 = scanner.nextInt();
            if (num1 > num2) {
                System.out.println(num1);
            } if (num1 == num2) {
                System.out.println(num1 + " = " + num2);
            } else {
                System.out.println(num2);
            }
        } while (num1 != -1 || num2 != -1);

    }
}
