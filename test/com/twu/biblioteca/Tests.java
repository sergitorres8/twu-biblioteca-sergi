package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void welcomeMessageTest() {
        assertEquals("Dear client, Welcome to the library application.\n", BibliotecaApp.welcomeMessage());
    }

    @Test
    public void listOfBooksTest() {
      //  Book harrypotter = new Book("Harry Potter", "J. K. Rowling", 1997);
      //  Book lot = new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954);
      //  ArrayList<Book> bookslist = MainMenu.listOfBooks();
        //assertTrue(harrypotter.equals(bookslist.get(0)));
       // assertSame(lot,bookslist.get(1));
    }

    @Test
    public void booksDetailsTest() {
      //  assertEquals("akdsjhlkhkahdskf", "adfajdlf");
    }
}
