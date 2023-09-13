package Powtutka.Book;

public class Main {
    public static void main(String[] args) {
        Book[] books =
                {new Book("Lord of rings",
        "Kirill Hlushakou", 2004),
                new Book("fijeijio", "jdigjoej", 12),
                new Book("cjaojf;o", "dskjgnv", 34)};

        for (int i = 0; i < books.length; i++) {
            books[i].print();
        }
    }
}