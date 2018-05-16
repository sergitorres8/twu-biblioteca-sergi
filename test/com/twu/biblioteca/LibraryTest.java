package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LibraryTest {
    private Library library;
    private Optional<LibraryItem> checkedOutBook;
    private Optional<LibraryItem> returnedBook;
    @Test
    public void shouldCheckoutBookFromLibrary(){
        givenThereIsOneBookInTheLibrary();
        whenWeCheckOutABook(new Book("Harry Potter", "J. K. Rowling", 1997));
        thenTheLibraryIsEmpty();
        andTheBookIsReturnedFromTheCheckout();
    }

    @Test
    public void shouldReturnEmptyOptionalIfBookUnavailable(){
        givenThereIsOneBookInTheLibrary();
        checkedOutBook = whenWeCheckOutABookThatDoesntExist(new Book("Harry Doesn't Exist", "dfd", 1947));
        thenNoBookIsReturned(checkedOutBook);
    }

    private Optional<LibraryItem> whenWeCheckOutABookThatDoesntExist(LibraryItem libraryItem) {
        checkedOutBook = library.checkout(libraryItem);
        return checkedOutBook;
    }

    @Test
    public void shouldReturnEmptyOptionalWhenListOfBooksIsEmpty() {
        givenThereIsNoBooks();
        checkedOutBook = whenWeCheckOutABook(new Book("Harry Peter", "J. K. Rowling", 1997));
        thenNoBookIsReturned(checkedOutBook);
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
        returnedBook = library.returnItem(new Book("Harry Peter", "J. K. Rowling", 1997));
    }

    private void thenWeShouldHaveThatBookInTheList() {
        Assert.assertEquals(Optional.empty(), returnedBook);
    }

    private void whenWeReturnABook() {
        returnedBook = library.returnItem(new Book("Harry Potter", "J. K. Rowling", 1997));
    }

    private void givenThereIsNoBooks() {
        List<Book> listOfBooks = new ArrayList<>();
        library = new Library(listOfBooks);
    }

    private void andTheBookIsReturnedFromTheCheckout() {
        Book book = (Book) checkedOutBook.get();
        Assert.assertEquals(new Book("Harry Potter", "J. K. Rowling", 1997), book);
    }


    private void thenNoBookIsReturned(Optional<LibraryItem> checkedOutBook) {
        Assert.assertEquals(Optional.empty(), checkedOutBook);
    }

    private void thenTheLibraryIsEmpty() {
        Assert.assertEquals(0, library.getBooks().size());
    }

    private Optional<LibraryItem> whenWeCheckOutABook(LibraryItem item) {
        checkedOutBook = library.checkout(item);
        return checkedOutBook;
    }

    private void givenThereIsOneBookInTheLibrary() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Harry Potter", "J. K. Rowling", 1997));
        library = new Library(list);
    }
}
