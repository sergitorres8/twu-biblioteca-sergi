package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LibraryTest {
    private Library library;
    private Optional<Book> checkedoutBook;
    @Test
    public void shouldCheckoutBookFromLibrary(){
        givenThereIsOneBookInTheLibrary();
        whenWeChechoutABook(new Book("Harry Potter", "J. K. Rowling", 1997, true));
        thenTheLibraryIsEmpty();
        andTheBookIsReturnedFromTheCheckout();
    }

    @Test
    public void shouldReturnEmptyOptionalIfBookUnavailable(){
        givenThereIsOneBookInTheLibrary();
        whenWeChechoutABook(new Book("Harry Peter", "J. K. Rowling", 1997, true));
        thenNoBookIsReturned();
    }

    @Test
    public void shouldReturnEmptyOptionalWhenListOfBooksIsEmpty() {
        givenThereIsNoBooks();
        whenWeChechoutABook(new Book("Harry Peter", "J. K. Rowling", 1997, true));
        thenNoBookIsReturned();
    }

    private void givenThereIsNoBooks() {
        List<Book> listofbooks = new ArrayList<>();
        library = new Library(listofbooks);
    }

    private void andTheBookIsReturnedFromTheCheckout() {
        Assert.assertEquals(new Book("Harry Potter", "J. K. Rowling", 1997, true), checkedoutBook.get());
    }


    private void thenNoBookIsReturned() {
        Assert.assertEquals(Optional.empty(), checkedoutBook);
    }

    private void thenTheLibraryIsEmpty() {
        Assert.assertEquals(0, library.getBooks().size());
    }

    private void whenWeChechoutABook(Book book) {
        checkedoutBook = library.checkout(book);
    }

    private void givenThereIsOneBookInTheLibrary() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Harry Potter", "J. K. Rowling", 1997, true));
        library = new Library(list);
    }
}
