package Junior_java_develop.TASK3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kirill", 19));
        people.add(new Person("Nadia", 20));
        people.add(new Person("Julia", 18));
        people.add(new Person("Igor", 17));

        Collections.sort(people, Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
