package com.twu.biblioteca;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;

public class Navigator {
    InputParser inputParser;
    Library library;
    Printer  printer;
    User user;

    public Navigator(Library library) {
        this.inputParser = new InputParser();
        this.library = library;
        this.printer = new Printer();
    }

    public void menu(int choice){
        switch (choice){
            case 1:
                if (library.getBooks().size() == 0)
                    printer.thereArentAvailableBooks();
                else
                    printer.listAvailableBooks(library.getBooks());
                break;
            case 2:
                Book bookToCheckOut = selectABookToCheckOutOrReturn();
                if (bookToCheckOut != null && library.getBooks().contains(bookToCheckOut)) {
                    library.checkout(bookToCheckOut);
                    user.setCheckedOutItemsToReturn(bookToCheckOut);
                    printer.bookCheckedOut();
                }
                else
                    printer.bookUnavailable();
                break;
            case 3:
                Book bookToReturn = selectABookToCheckOutOrReturn();
                if (bookToReturn != null && !library.getBooks().contains(bookToReturn)) {
                    library.returnBook(bookToReturn);
                    printer.bookReturned();
                }
                else
                    printer.bookUnavailable();
                break;
            case 4:
                if (library.getMovies().size() == 0)
                    printer.thereArentAvailableMovies();
                else
                    printer.listAvailableMovies(library.getMovies());
                break;
            case 5:
                Movie movieToCheckOut = selectAMovieToCheckOutOrReturn();
                if (movieToCheckOut != null && library.getMovies().contains(movieToCheckOut)) {
                    library.checkout(movieToCheckOut);
                    user.setCheckedOutItemsToReturn(movieToCheckOut);
                    printer.MovieCheckedOut();
                }
                else
                    printer.movieUnavailable();
                break;
            case 6:
                Movie movieToReturn = selectAMovieToCheckOutOrReturn();
                if (movieToReturn != null && !library.getMovies().contains(movieToReturn)) {
                    library.returnBook(movieToReturn);
                    printer.movieReturned();
                }
                else{
                    printer.movieUnavailable();
                }
                break;
            case 7:
                printer.displayUserInformation(user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getCheckedOutItemsToReturn());
                break;
        }
    }


    public Book selectABookToCheckOutOrReturn() {
        printer.typetitleOfBook();
        String inputTitle = inputParser.askForForTitle();
        Optional<Book> optionalBook = library.getBookByTitle(inputTitle);
        if (optionalBook.isPresent())
            return optionalBook.get();
        return null;
    }

    public Movie selectAMovieToCheckOutOrReturn() {
        printer.typetitleOfMovie();
        String inputTitle = inputParser.askForForTitle();
        Optional<Movie> optionalMovie = library.getMovieByTitle(inputTitle);
        if (optionalMovie.isPresent())
            return optionalMovie.get();
        return null;
    }

    public int selectAnActionFromMenu() {
        try {
            printer.whatActionWouldYouLikeToDo();
            int choice = inputParser.askForNumber();
            if(choice < 0 || choice > 7)
                throw new InputMismatchException("\nThis option is not available.");
            return choice;
        } catch (InputMismatchException e){
            printer.wrongInputMenu();
            selectAnActionFromMenu();
        }
        return 0;
    }

    public boolean loginUser() {
        printer.loginAsUser();
        String loginNumber, passWord;
        loginNumber = inputParser.askForLoginNumber();
        printer.loginAsUserPassword();
        passWord = inputParser.askForForPassword();
        if (library.loginUser(loginNumber, passWord).isPresent()) {
            user = library.loginUser(loginNumber, passWord).get();
            return true;
        }
        else
            return false;
    }
}
