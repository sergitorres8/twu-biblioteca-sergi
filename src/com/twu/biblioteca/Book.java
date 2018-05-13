package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Integer year;
    private Boolean available;

    public Book(String title, String author, Integer year, Boolean available) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() { return year; }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year) &&
                Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, year, available);
    }
}
