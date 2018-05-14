package com.twu.biblioteca;

import java.util.Objects;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, Integer year) {
        super(title, year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), getTitle()) &&
                Objects.equals(author, book.author) &&
                Objects.equals(getYear(), book.getYear());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), author, getYear());
    }
}
