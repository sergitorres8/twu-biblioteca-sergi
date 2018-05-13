package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<Book> catalogOfBooks;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library() {
        this.catalogOfBooks = new ArrayList<>();
        catalogOfBooks.add(new Book("Harry Potter", "J. K. Rowling", 1997, true));
        catalogOfBooks.add(new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954, true));
        this.books = new ArrayList<>();
        this.books = copyList(catalogOfBooks, books);
    }

    public Optional<Book> checkout(Book book) {
        Boolean deleted = books.remove(book);
        if(!deleted)
            return Optional.empty();
        return Optional.of(book);
    }

    public Optional<Book> returnBook(Book book) {
        if(catalogOfBooks.contains(book) || books.size() == 0){
            books.add(book);
            return Optional.of(book);
        }
        return Optional.empty();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Optional<Book> getBookByTitle(String title){
        for (Book book: catalogOfBooks){
            if (title.equals(book.getTitle()))
                return Optional.of(book);
        }
        return Optional.empty();
    }

    public List<Book> copyList(List<Book> list, List<Book> listToCopy){
        for (Book book : list){
            listToCopy.add(book);
        }
        return listToCopy;
    }

}
