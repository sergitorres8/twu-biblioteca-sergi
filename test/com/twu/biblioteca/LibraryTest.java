package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LibraryTest {
    private Library library;
    private Optional<Book> checkedOutBook;
    private Optional<Book> returnedBook;
    @Test
    public void shouldCheckoutBookFromLibrary(){
        givenThereIsOneBookInTheLibrary();
        whenWeChechoutABook(new Book("Harry Potter", "J. K. Rowling", 1997));
        thenTheLibraryIsEmpty();
        andTheBookIsReturnedFromTheCheckout();
    }

    @Test
    public void shouldReturnEmptyOptionalIfBookUnavailable(){
        givenThereIsOneBookInTheLibrary();
        whenWeChechoutABook(new Book("Harry Peter", "J. K. Rowling", 1997));
        thenNoBookIsReturned();
    }

    @Test
    public void shouldReturnEmptyOptionalWhenListOfBooksIsEmpty() {
        givenThereIsNoBooks();
        whenWeChechoutABook(new Book("Harry Peter", "J. K. Rowling", 1997));
        thenNoBookIsReturned();
    }

    @Test
    public void shouldReturnBookToLibrary() {
        givenThereIsNoBooks();
        whenWeReturnABook();
        thenWeShouldHaveThatBookInTheList();
    }

    @Test
    public void shouldReturnBookJustWhenTheBookExists() {
        givenThereIsOneBookInTheLibrary();
        whenWeReturnABookThatDoesntExists();
        thenTheBookIsNotReturnedToTheLibrary();
    }



    private void thenTheBookIsNotReturnedToTheLibrary() {
        Assert.assertEquals(Optional.empty(), returnedBook);
    }

    private void whenWeReturnABookThatDoesntExists() {
//        returnedBook = library.returnBook(new Book("Harry Peter", "J. K. Rowling", 1997));
    }

    private void thenWeShouldHaveThatBookInTheList() {
        Assert.assertEquals(new Book("Harry Potter", "J. K. Rowling", 1997), library.returnBook(new Book("Harry Potter", "J. K. Rowling", 1997)).get());
    }

    private void whenWeReturnABook() {
        library.returnBook(new Book("Harry Potter", "J. K. Rowling", 1997));
    }

    private void givenThereIsNoBooks() {
        List<Book> listOfBooks = new ArrayList<>();
        library = new Library(listOfBooks);
    }

    private void andTheBookIsReturnedFromTheCheckout() {
        Assert.assertEquals(new Book("Harry Potter", "J. K. Rowling", 1997), checkedOutBook.get());
    }


    private void thenNoBookIsReturned() {
        Assert.assertEquals(Optional.empty(), checkedOutBook);
    }

    private void thenTheLibraryIsEmpty() {
        Assert.assertEquals(0, library.getBooks().size());
    }

    private void whenWeChechoutABook(Book book) {
//        checkedOutBook = library.checkout(book);
    }

    private void givenThereIsOneBookInTheLibrary() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Harry Potter", "J. K. Rowling", 1997));
        library = new Library(list);
    }
}
