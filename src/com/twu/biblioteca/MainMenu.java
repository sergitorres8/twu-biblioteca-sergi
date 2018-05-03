package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {
    Scanner reader = new Scanner(System.in);
    private String[] options = new String[]{"List Books"};

    public Integer chooseOption() {
        System.out.println("Please, choose an option: ");
        System.out.println("[1]  " + options[0] + "\n");
        System.out.println("Select an option: ");
        int n = reader.nextInt();
        reader.close();
        return n;
    }

    public void optionChosen(Integer n) {
        if (n == 1)
            listOfBooks();
    }

    public static ArrayList<Book> listOfBooks() {
        ArrayList<Book> books = new ArrayList();
        System.out.println("These are the books available: \n");
        System.out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");
        books.add(0, new Book("Harry Potter", "J. K. Rowling", 1997));
        books.add(1, new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954));


        for (Book book : books) {
            System.out.printf("%-20s %-20s %-20s\n", book.getTitle(), book.getAuthor(), book.getYear());
        }
        return books;
    }
}
