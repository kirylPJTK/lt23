package SomeIntro.TASK2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Просмотреть задачи");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Отметить задачу выполненной");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите задачу: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    writeList("ToDoList.txt", task);
                    System.out.println("Задача добавлена.");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.println("Список задач:");
                        showList("ToDoList.txt");
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
                            System.out.println("Задача удалена.");
                            // Теперь удаляем из файла
                            deleteTask("ToDoList.txt", taskNumber - 1);
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
                            // Теперь удаляем из файла
                            deleteTask("ToDoList.txt", taskNumber - 1);
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

    public static void writeList(String filename, String info) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(info);
            writer.append('\n');
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void showList(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            int i = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(i++ + ") " + line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

   public static void deleteTask(String fileName, int taskIndex) {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i!=taskIndex) {
                    lines.add(line);
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());

        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String updateLine : lines) {
                writer.write(updateLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
   }
}
