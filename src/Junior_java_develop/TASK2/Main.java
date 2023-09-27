package Junior_java_develop.TASK2;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Введите первое число: ");
//
//
//        int num1 = scanner.nextInt();
//
//        System.out.print("Введите второе число: ");
//
//        int num2 = scanner.nextInt();
//
//        try {
//            int result = num1 / num2;
//            System.out.println("Результат деления: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("ERROR KURWA JEBANA NIE MOZNA NA 0!!!");
//        }

        System.out.print("Введите строку, которую нужно преобразовать в число: ");

        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.println("Вы ввели число: " + number);
        } catch (NumberFormatException x) {
            System.out.println("KURWA JEBANA TAK NIE MOZNA!!!");
        }


    }

}
