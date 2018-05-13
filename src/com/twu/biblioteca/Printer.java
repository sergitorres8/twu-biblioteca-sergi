package com.twu.biblioteca;

import com.sun.org.apache.regexp.internal.RE;
import javafx.scene.effect.BlurType;

import java.io.PrintStream;
import java.util.List;


public class Printer {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE


    public PrintStream out = new PrintStream(System.out);

    public void welcomeMessage(){
        out.println(YELLOW + "\nDear client, Welcome to the library application.\n" + RESET);
    }

    public void listAvailableBooks(List<Book> books) {
        out.println("These are the available books:\n");
        out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");
        for (Book book : books)
            out.printf(BLUE + "%-20s %-20s %-20s\n" + RESET, book.getTitle(), book.getAuthor(), book.getYear());

    }

    public void whatActionWouldYouLikeToDo() {
        out.println("\nWhat option would you like to choose(1, 2, 3 or 0): ");
        out.println(CYAN + "\n[1]     List All Books Available\n" +
                "[2]     Check out book\n" +
                "[3]     Return book\n" +
                "[0]     Quit"+ RESET);

    }

    public void bookUnavailable() {
        out.printf(RED + "\nThis book is unavailable.\n" + RESET);
    }

    public void typetitleOfBook() {
        out.printf("\nPlease type the title of the book:\n");
    }

    public void bookCheckedOut() {
        out.printf("\nThank you! Enjoy the book!\n");
    }

    public void thereArentAvailableBooks() {
        out.printf("\nThere aren't any available books.\n");
    }

    public void bookReturned() {
        out.printf("\nThank you for returning the book.\n");
    }

    public void wrongInputMenu() {
        out.printf(RED + "\nSelect a valid option!\n"+ RESET);
    }
}
