package com.twu.biblioteca;

import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Optional<Book> checkout(Book book) {
        Boolean deleted = books.remove(book);
        if(!deleted)
            return Optional.empty();
        return Optional.of(book);
    }

    public List<Book> getBooks() {
        return books;
    }

}
