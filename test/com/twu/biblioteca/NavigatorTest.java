package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class NavigatorTest {
    Navigator nav;
    Library lib;
    Book book;
    LibraryItem libraryItem;
    InputParser inputParser;
    @Test
    public void listBookWhenInputIs1() {
        givenThereIsOneBookInTheLibrary();
        whenWeSelect1();
        thenListBooksWillBeCalled();
    }

    @Test
    public void shouldCheckOutWhenWeSelectOption2() {
        givenThereIsOneBookInTheLibraryToCheckout();
        whenWeSelect2();
        thenCheckOutBook();
    }

    private void thenCheckOutBook() {
        Mockito.verify(lib, Mockito.times(1)).checkout(book);
    }

    private void givenThereIsOneBookInTheLibraryToCheckout() {
        lib = Mockito.mock(Library.class);
        book = Mockito.mock(Book.class);
        inputParser = Mockito.mock(InputParser.class);
//        ArrayList<Book> books = new ArrayList(Arrays.asList(Mockito.mock(Book.class)));
//        Mockito.when(lib.getBooks()).thenReturn(books);
        nav = new Navigator(lib);
        Mockito.when(nav.selectABookToCheckOutOrReturn()).thenReturn(book);
        Mockito.when(inputParser.askForForTitle()).thenReturn(null);
    }

    private void whenWeSelect2() {
        nav.menu(2);
    }

    private void givenThereIsOneBookInTheLibrary() {
        lib = Mockito.mock(Library.class);
        ArrayList<Book> books = new ArrayList(Arrays.asList(Mockito.mock(Book.class)));
        Mockito.when(lib.getBooks()).thenReturn(books);
        nav = new Navigator(lib);
    }

    private void thenListBooksWillBeCalled() {
        Mockito.verify(lib, Mockito.times(2)).getBooks();
    }

    private void whenWeSelect1() {
        nav.menu(1);
    }

}
