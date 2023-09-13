package Powtutka.Book;

public class Book {
    private String name;
    private String author;
    private int yearOfRealis;

    public Book(String name, String author, int yearOfRealis) {
        this.name = name;
        this.author = author;
        this.yearOfRealis = yearOfRealis;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfRealis() {
        return yearOfRealis;
    }

    public void print() {
        System.out.println("Name of the book: " +
                getName() + "\n The author's name is: " + getAuthor() +
                "\n The year of realis is: " + getYearOfRealis());
    }
}
