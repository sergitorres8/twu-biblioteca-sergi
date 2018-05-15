package com.twu.biblioteca;

import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class NavigatorTest {
    Navigator nav;
    Library lib;
    LibraryItem libraryItem;
    Book book;


    @Test
    public void listBookWhenInputIs1() {
        givenThereIsOneBookInTheLibrary();
        whenWeSelect1();
        thenListBooksWillBeCalled();
    }

    @Test
    public void shouldCallCheckOutWhenInputIs2() {
        lib =  Mockito.mock(Library.class);
        libraryItem = Mockito.mock(LibraryItem.class);
        book = Mockito.mock(Book.class);
        nav = new Navigator(lib);
//        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.of(libraryItem));

//        nav.menu(5);
        Mockito.verify(lib, Mockito.atLeastOnce()).checkout(libraryItem);
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
