package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<Book> catalogOfBooks;
    private List<Movie> movies;
    private List<Movie> catalogOfMovies;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library() {
        this.catalogOfBooks = new ArrayList<>();
        catalogOfBooks.add(new Book("Harry Potter", "J. K. Rowling", 1997));
        catalogOfBooks.add(new Book("Lord Of The Rings", "J. R. R. Tolkien", 1954));
        this.books = new ArrayList<>();
        this.books = copyList(catalogOfBooks, books);
        this.catalogOfMovies = new ArrayList<>();
        catalogOfMovies.add(new Movie("Interstellar", 2014, "Christopher Nolan", 8.9f));
        catalogOfMovies.add(new Movie("The Hobbit", 2012, "Peter Jackson", 8.6f));
        this.movies = new ArrayList<>();
        this.movies = copyList(catalogOfMovies, movies);
    }

    public Optional<LibraryItem> checkout(LibraryItem libraryItem) {
        if (libraryItem instanceof Book) {
            Book book = (Book) libraryItem;
            books.remove(book);
            return Optional.of(book);
        }
        else if(libraryItem instanceof Movie){
            Movie movie = (Movie) libraryItem;
            movies.remove(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public Optional<LibraryItem> returnBook(LibraryItem libraryItem) {

        if (libraryItem instanceof Book) {
            Book book = (Book) libraryItem;
            if(catalogOfBooks.contains(book) || books.size() == 0){
                books.add(book);
                return Optional.of(book);
            }
        }
        else if(libraryItem instanceof Movie){
            Movie movie = (Movie) libraryItem;
            if(catalogOfMovies.contains(movie) || movies.size() == 0){
                movies.add(movie);
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Optional<Book> getBookByTitle(String title){
        for (Book book: catalogOfBooks){
            if (title.equals(book.getTitle()))
                return Optional.of(book);
        }
        return Optional.empty();
    }

    public Optional<Movie> getMovieByTitle(String title){
        for (Movie movie: catalogOfMovies){
            if (title.equals(movie.getTitle()))
                return Optional.of(movie);
        }
        return Optional.empty();
    }

    public List copyList(List list, List listToCopy){
        for (Object libraryItem : list){
            listToCopy.add(libraryItem);
        }
        return listToCopy;
    }
}
