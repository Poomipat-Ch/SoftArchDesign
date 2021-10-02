package Book.com.solid.book;


import Book.com.solid.book.IBook.File;

import java.util.List;

public class BookPublisher {
    public static void main(String[] args) {
        File book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        book.printToFile();
    }
}
