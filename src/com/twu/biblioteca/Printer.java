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
        out.println("\nThese are the available books:\n");
        out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");
        for (Book book : books)
            out.printf(BLUE + "%-20s %-20s %-20s\n" + RESET, book.getTitle(), book.getAuthor(), book.getYear());

    }

    public void whatActionWouldYouLikeToDo() {
        out.println("\nWhat option would you like to choose [0-7]: ");
        out.println(CYAN + "\n[1]     List All Books Available\n" +
                "[2]     Check out book\n" +
                "[3]     Return book\n" +
                "[4]     List All Movies Available\n" +
                "[5]     Check Out movie\n" +
                "[6]     Return movie\n" +
                "[7]     View User Information\n" +
                "[0]     Quit"+ RESET);

    }

    public void bookUnavailable() {
        out.printf(RED + "\nThis book is unavailable.\n" + RESET);
    }

    public void typetitleOfBook() {
        out.printf("\nPlease type the title of the book:\n");
    }

    public void bookCheckedOut() {
        out.printf(YELLOW + "\nThank you! Enjoy the book!\n" + RESET);
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

    public void thereArentAvailableMovies() {
        out.printf("\nThere aren't any available movies.\n");
    }

    public void listAvailableMovies(List<Movie> movies) {
        out.println("\nThese are the available movies:\n");
        out.printf("%-20s %-20s %-10s %-10s\n", "Title", "Director", "Year", "Rating");
        for (Movie movie : movies)
            out.printf(BLUE + "%-20s %-20s %-10s %-10s\n" + RESET, movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating());
    }

    public void movieUnavailable() {
            out.printf(RED + "\nThis movie is unavailable.\n" + RESET);
    }

    public void MovieCheckedOut()  {
        out.printf(YELLOW + "\nThank you! Enjoy the movie!\n" + RESET);
    }

    public void typetitleOfMovie() {
        out.printf("\nPlease type the title of the movie.\n");
    }

    public void movieReturned() {
        out.printf(YELLOW + "\nThank you for returning the movie.\n"+ RESET);
    }

    public void loginAsUser() {
        out.printf("\nPlease type your login number(xxx-xxxx):\n");
    }
    public void loginAsUserPassword() {
        out.printf("\nPlease type your password:\n");
    }

    public void displayUserInformation(String userName, String email, String phoneNumber, List<LibraryItem> checkedOutItemsToReturn) {
        out.println("\nThese are the available movies:\n");
        out.printf("%-20s %-30s %-20s\n", "User Name", "Email", "Phone Number");
        out.printf(BLUE + "%-20s %-30s %-20s\n" + RESET, userName, email, phoneNumber);
        for (LibraryItem item: checkedOutItemsToReturn){
            if (item instanceof Book) {
                Book book = (Book) item;
                out.printf("\nYou have this book pending return:\n");
                out.printf("%-20s %-20s %-20s\n", "Title", "Author", "Year");
                out.printf(BLUE + "%-20s %-20s %-10s\n" + RESET, book.getTitle(), book.getAuthor(), book.getYear());
            }
            else if(item instanceof Movie){
                Movie movie = (Movie) item;
                out.printf("\nYou have this movie pending return:\n");
                out.printf("%-20s %-20s %-10s %-10s\n", "Title", "Director", "Year", "Rating");
                out.printf(BLUE + "%-20s %-20s %-10s %-10s\n" + RESET, movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getRating());
            }
        }
    }

    public void invalidUserOrPassword() {
        out.printf(RED + "\nThe user login number or password is wrong!\n"+ RESET);
    }
}
