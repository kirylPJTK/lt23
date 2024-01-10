package TasksFromLeetCodeORother.LinkedListClass;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Создание LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Добавление элементов в конец списка
        linkedList.add("Первый");
        linkedList.add("Второй");
        linkedList.add("Третий");

        // Добавление элемента в начало списка
        linkedList.addFirst("Новый первый");

        // Вставка элемента на определенную позицию
        linkedList.add(2, "Вставленный");

        // Удаление элемента с определенной позиции
        linkedList.remove(3);

        // Обход элементов и вывод на экран
        for (String element : linkedList) {
            System.out.println(element);
        }
    }
}
