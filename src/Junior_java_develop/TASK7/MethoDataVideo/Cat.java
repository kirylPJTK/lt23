package Junior_java_develop.TASK7.MethoDataVideo;
@VeryImportant
public class Cat {

    @ImportantString
    public String name;

    public Cat(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("Meow");
    }

    public void eat() {
        System.out.println("Munch");
    }
}
