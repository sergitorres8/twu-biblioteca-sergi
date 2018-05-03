package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
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


    public boolean equals(Book o) {
        if (this.title == o.title && this.author == o.author && this.year == o.year)
            return true;
        return false;
    }

}
