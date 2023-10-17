package SomeIntro.TASK2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) {
        List<String> tasks = loadTasks();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Просмотреть задачи");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Отметить задачу выполненной");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера после ввода числа

            switch (choice) {
                case 1:
                    System.out.print("Введите задачу: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    saveTasks(tasks);
                    System.out.println("Задача добавлена.");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.println("Список задач:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ") " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.print("Введите номер задачи для удаления: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            tasks.remove(taskNumber - 1);
                            saveTasks(tasks);
                            System.out.println("Задача удалена.");
                        } else {
                            System.out.println("Неверный номер задачи.");
                        }
                    }
                    break;
                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.print("Введите номер задачи для отметки выполненной: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            System.out.println("Задача '" + tasks.get(taskNumber - 1) + "' отмечена выполненной.");
                            tasks.remove(taskNumber - 1);
                            saveTasks(tasks);
                        } else {
                            System.out.println("Неверный номер задачи.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Выход из приложения.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static List<String> loadTasks() {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ToDoList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            // В случае ошибки чтения, просто вернем пустой список
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return tasks;
    }

    private static void saveTasks(List<String> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ToDoList.txt"))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
