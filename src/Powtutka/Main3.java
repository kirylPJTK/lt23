package Powtutka;

import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        // Задайте размер массива
        int size = 10; // Измените размер, если нужно

        // Создайте массив целых чисел
        int[] arr = new int[size];

        // Заполните массив случайными числами
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // Генерируйте случайные числа в диапазоне от 0 до 99 (вы можете изменить диапазон)
        }

        // Найдите сумму всех элементов массива
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }

        // Выведите результат на экран
        System.out.println("Массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nСумма всех элементов: " + sum);
    }
}
