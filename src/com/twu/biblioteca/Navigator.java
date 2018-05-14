package com.twu.biblioteca;


import java.util.InputMismatchException;
import java.util.Optional;

public class Navigator {
    InputParser inputParser;
    Library library;
    Printer  printer;

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
                Book bookToCheckOut = selectABookToCheckOut();
                if (bookToCheckOut != null) {
                    library.checkout(bookToCheckOut);
                    printer.bookCheckedOut();
                }
                break;
            case 3:
                Book bookToReturn = selectABookToReturn();
                if (bookToReturn != null) {
                    library.returnBook(bookToReturn);
                    printer.bookReturned();
                }
                break;
            case 4:
                if (library.getMovies().size() == 0)
                    printer.thereArentAvailableMovies();
                else
                    printer.listAvailableMovies(library.getMovies());
                break;
            case 5:
                Movie movieToCheckOut = selectAMovieToCheckOut();
                if (movieToCheckOut != null) {
                    library.checkout(movieToCheckOut);
                    printer.MovieCheckedOut();
                }
                break;
            case 6:
                Movie movieToReturn = selectAMovieToReturn();
                if (movieToReturn != null) {
                    library.returnBook(movieToReturn);
                    printer.movieReturned();
                }
                break;
        }
    }

    private Movie selectAMovieToReturn() {
        printer.typetitleOfMovie();
        String inputTitle = inputParser.askForForTitle();
        Optional<Movie> optionalMovie = library.getMovieByTitle(inputTitle);
        if (optionalMovie.isPresent())
            return optionalMovie.get();
        else {
            printer.movieUnavailable();
            return null;
        }
    }

    private Book selectABookToReturn() {
        printer.typetitleOfBook();
        String inputTitle = inputParser.askForForTitle();
        Optional<Book> optionalBook = library.getBookByTitle(inputTitle);
        if (optionalBook.isPresent())
            return optionalBook.get();
        else {
            printer.bookUnavailable();
            return null;
        }
    }

    private Book selectABookToCheckOut() {
        printer.typetitleOfBook();
        String inputTitle = inputParser.askForForTitle();
        Optional<Book> optionalBook = library.getBookByTitle(inputTitle);
        if (optionalBook.isPresent() && library.getBooks().contains(optionalBook.get()))
            return optionalBook.get();
        else {
            printer.bookUnavailable();
            return null;
        }
    }

    private Movie selectAMovieToCheckOut() {
        printer.typetitleOfMovie();
        String inputTitle = inputParser.askForForTitle();
        Optional<Movie> optionalMovie = library.getMovieByTitle(inputTitle);
        if (optionalMovie.isPresent() && library.getMovies().contains(optionalMovie.get()))
            return optionalMovie.get();
        else {
            printer.movieUnavailable();
            return null;
        }
    }

    public int selectAnActionFromMenu() {
        try {
            printer.whatActionWouldYouLikeToDo();
            int choice = inputParser.askForNumber();
            if(choice < 0 || choice > 6)
                throw new InputMismatchException("\nThis option is not available.");
            return choice;
        } catch (InputMismatchException e){
            printer.wrongInputMenu();
            selectAnActionFromMenu();
        }
        return 0;
    }

}
