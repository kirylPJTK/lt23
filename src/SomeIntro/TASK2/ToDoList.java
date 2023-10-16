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
                    writeList(task);
                    System.out.println("Задача добавлена.");
                    break;
                case 2:
                    if (isFileEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.println("Список задач:");
                        showlist();
                    }
                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        System.out.println("Введите номер задачи для удаления: ");
                        int taskNumber = scanner.nextInt();
                        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                            tasks.remove(taskNumber - 1);
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

    public static void writeList(String info) {
        try ( FileWriter writer = new FileWriter("ToDoList.txt", true)){
           writer.append(info);
           writer.append('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void showlist() {
        String filePath = "/Users/kirillglusakov/IdeaProjects/Lato 2023/ToDoList.txt";

        try {
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int i = 1;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(i++ + ") " + line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static boolean isFileEmpty() {
        File file = new File("/Users/kirillglusakov/IdeaProjects/Lato 2023/ToDoList.txt"); //  путь к файлу

        return file.exists() && file.length() == 0;
    }

    public static void deleteInfo(int taskNumber) {
        String filePath = "/Users/kirillglusakov/IdeaProjects/Lato 2023/ToDoList.txt";
//        String lineToRemove = "Строка для удаления";

        // Прочитайте файл и исключите строку
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(taskNumber)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запишите оставшиеся строки обратно в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
