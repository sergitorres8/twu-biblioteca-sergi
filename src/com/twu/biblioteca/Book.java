package com.twu.biblioteca;

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

    public Integer getYear() {
        return year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean equals(Book o) {
        if (this.title == o.title && this.author == o.author && this.year == o.year)
            return true;
        return false;
    }

}
