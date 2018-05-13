package com.twu.biblioteca;


import org.junit.Test;

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
        }
    }

    private Book selectABookToReturn() {
        printer.typetitleOfBook();
        String inputTitle = inputParser.askForBookTitle();
        Optional<Book> optionalBook = library.getBookByTitle(inputTitle);
        System.out.printf(optionalBook.toString());
        if (optionalBook.isPresent())
            return optionalBook.get();
        else {
            printer.bookUnavailable();
            return null;
        }
    }

    private Book selectABookToCheckOut() {
        printer.typetitleOfBook();
        String inputTitle = inputParser.askForBookTitle();
        Optional<Book> optionalBook = library.getBookByTitle(inputTitle);
        if (optionalBook.isPresent() && library.getBooks().contains(optionalBook.get()))
            return optionalBook.get();
        else {
            printer.bookUnavailable();
            return null;
        }
    }

    public int selectAnActionFromMenu() {
        try {
            printer.whatActionWouldYouLikeToDo();
            int choice = inputParser.askForNumber();
            if(choice < 0 || choice > 3)
                throw new InputMismatchException("\nThis option is not available.");
            return choice;
        } catch (InputMismatchException e){
            printer.wrongInputMenu();
            selectAnActionFromMenu();
        }
        return 0;
    }

}
