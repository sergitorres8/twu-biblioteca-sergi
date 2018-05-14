package com.twu.biblioteca;

public class Movie extends LibraryItem{
    private String director;
    private float rating;

    public Movie(String name, int year, String director, float rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public float getRating() {
        return rating;
    }
}
