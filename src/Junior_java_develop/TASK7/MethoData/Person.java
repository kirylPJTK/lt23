package Junior_java_develop.TASK7.MethoData;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // Другие методы, включая equals

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        // Используем hashCode
        int hashCode1 = person1.hashCode();
        int hashCode2 = person2.hashCode();

        System.out.println("HashCode for person1: " + hashCode1);
        System.out.println("HashCode for person2: " + hashCode2);
    }
}
