package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {

        welcomeMessage();
        listOfBooks();
    }

    public static void welcomeMessage() {
        System.out.println("Dear client, Welcome to the library application.\n");
    }

    public static void listOfBooks() {
        ArrayList<Book> books = new ArrayList();
        books.add(0, new Book("Harry Potter", "J. K. Rowling", 1997));
        books.add(1, new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954));
        System.out.println("These are the books available:");

        for(Book book: books){
            System.out.printf("%-20s %-20s %-20s\n", book.getTitle(), book.getAuthor(), book.getYear());
        }

    }
}
