package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {

    private HashMap<Integer, String> options = new HashMap<Integer, String>();

    public void setOptions() {
        this.options.put(1, "List Books");
        this.options.put(0, "Quit");
    }

    public void optionsAvailable() {
        System.out.println("\nPlease, choose an option: ");
        setOptions();
        System.out.println("[1]  " + options.get(1));
        System.out.println("[0]  " + options.get(0));

    }

    public Integer checkInput() {
        Scanner reader = new Scanner(System.in);
        Boolean validInput = false;
        int attempts = 0;
        while (attempts<15) {
            String input = reader.next();
            if (input.matches("-?\\d+") && options.containsKey(Integer.parseInt(input))) {
                validInput = true;
                return Integer.parseInt(input);
            } else
                System.out.println("Select a valid option!");
            attempts += 1;
        }
        return 0;
    }

    public void optionChosen (Integer opt){
        if (opt == 1)
            listOfBooks();
    }

    public static ArrayList<Book> listOfBooks () {
        ArrayList<Book> books = new ArrayList();
        System.out.println("These are the books available: \n");
        System.out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");
        books.add(0, new Book("Harry Potter", "J. K. Rowling", 1997));
        books.add(1, new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954));


        for (Book book : books)
            System.out.printf("%-20s %-20s %-20s\n", book.getTitle(), book.getAuthor(), book.getYear());
        return books;
    }
}