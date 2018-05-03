package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {

    private HashMap<Integer, String> options = new HashMap<Integer, String>();
    private ArrayList<Book> books = new ArrayList();

    public void createBookList() {
        books.add(0, new Book("Harry Potter", "J. K. Rowling", 1997, true));
        books.add(1, new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954, true));
    }

    public void setOptions() {
        this.options.put(1, "List Books");
        this.options.put(0, "Quit");
        this.options.put(2, "Checkout Book");
    }

    public void optionsAvailable() {
        System.out.println("\nPlease, choose an option: ");
        setOptions();
        System.out.println("[1]  " + options.get(1));
        System.out.println("[2]  " + options.get(2));
        System.out.println("[0]  " + options.get(0));

    }

    public Integer checkInput() {
        Scanner reader = new Scanner(System.in);
        int attempts = 0;
        while (attempts<15) {
            String input = reader.next();
            if (input.matches("-?\\d+") && options.containsKey(Integer.parseInt(input))) {
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
        else if (opt == 2)
            checkOutBook();
    }

    private void checkOutBook() {
        System.out.println("\nWhich book would you like to checkout (Choose by Title):  ");
        Scanner reader = new Scanner(System.in);
        String checked_out_book = reader.nextLine();

        for (Book book : books){
            if (book.getTitle().equals(checked_out_book)){
                book.setAvailable(false);
            }
        }
    }

    public void listOfBooks () {
        System.out.println("These are the books available: \n");
        System.out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");

        for (Book book : books)
            if (book.getAvailable())
                System.out.printf("%-20s %-20s %-20s\n", book.getTitle(), book.getAuthor(), book.getYear());
    }
}