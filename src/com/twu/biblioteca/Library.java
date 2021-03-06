package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<Book> catalogOfBooks;
    private List<Movie> movies;
    private List<Movie> catalogOfMovies;
    private List<User> users;

    public Library(List<Book> books) {
        this.books = books;
        this.catalogOfBooks = new ArrayList<>();
        this.catalogOfBooks = copyList(books, catalogOfBooks);
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

        this.users = new ArrayList<>();
        users.add(new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509"));
        users.add(new User("000-0002","0002","Tony Stark", "tstark@thoughtworks.com", "88888888"));
    }

    public Optional<LibraryItem> checkout(LibraryItem libraryItem) {
        if (libraryItem instanceof Book && books.contains(libraryItem)) {
            Book book = (Book) libraryItem;
            books.remove(book);
            return Optional.of(book);
        }
        else if(libraryItem instanceof Movie && movies.contains(libraryItem)){
            Movie movie = (Movie) libraryItem;
            movies.remove(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public Optional<LibraryItem> returnItem(LibraryItem libraryItem) {

        if (libraryItem instanceof Book) {
            Book book = (Book) libraryItem;
            if(catalogOfBooks.contains(book) && !books.contains(book)){
                books.add(book);
                return Optional.of(book);
            }
        }
        else if(libraryItem instanceof Movie){
            Movie movie = (Movie) libraryItem;
            if(catalogOfMovies.contains(movie) && !movies.contains(movie)){
                movies.add(movie);
                return Optional.of(movie);
            }
        }
        return Optional.empty();
    }


    public Optional<User> loginUser(String loginNumber, String passWord){
        for (User user: users){
            if(user.login(loginNumber, passWord))
                return Optional.of(user);
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
