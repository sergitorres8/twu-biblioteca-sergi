package com.twu.biblioteca;

import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class NavigatorTest {
    Navigator nav;
    Library lib;
    LibraryItem libraryItem;
    Book book;
    InputParser inputParser;

    @Test
    public void listBookWhenInputIs1() {
        givenThereIsOneBookInTheLibrary();
        whenWeSelect1();
        thenListBooksWillBeCalled();
    }

    @Test
    public void shouldCallCheckOutWhenInputIs2() {
        givenThatWeWantToCheckOutAExistingBook();
        nav.menu(2);
        Mockito.verify(lib, Mockito.atLeastOnce()).checkout(libraryItem);
    }

    @Test
    public void shouldNotCallCheckOutWhenBookDoesNotExist() {
        lib =  Mockito.mock(Library.class);
        libraryItem = new Book("Potter", "hj", 97);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Potter");
        Mockito.when(lib.getBookByTitle("Potter")).thenReturn(Optional.empty());
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.empty());
        Mockito.when(lib.getBooks()).thenReturn(Arrays.asList((Book) libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");
        nav.menu(2);
        Mockito.verify(lib, Mockito.never()).checkout(libraryItem);
    }

    @Test
    public void shouldNotReturnBookWhenBookExistsButWasNotCheckedOutPreviously(){
        lib =  Mockito.mock(Library.class);
        libraryItem = new Book("Harry Potter", "J. K. Rowling", 1997);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(lib.getBooks()).thenReturn(Arrays.asList((Book) libraryItem));
        Mockito.when(inputParser.askForForTitle()).thenReturn("Harry Potter");
        Mockito.when(lib.getBookByTitle("Harry Potter")).thenReturn(Optional.of((Book) libraryItem));
        Mockito.when(lib.returnItem(libraryItem)).thenReturn(Optional.of(libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");
        nav.menu(3);
        Mockito.verify(lib, Mockito.never()).returnItem(libraryItem);
    }

    @Test
    public void shouldReturnBookWhenBookExistsAndWasCheckedOutPreviously(){
        lib =  Mockito.mock(Library.class);
        libraryItem = new Book("Harry Potter", "J. K. Rowling", 1997);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Harry Potter");
        Mockito.when(lib.getBookByTitle("Harry Potter")).thenReturn(Optional.of((Book) libraryItem));
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.of(libraryItem));
        Mockito.when(lib.getBooks()).thenReturn(Arrays.asList((Book) libraryItem));
        Mockito.when(lib.returnItem(libraryItem)).thenReturn(Optional.of(libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");

        nav.menu(2);
        Mockito.verify(lib, Mockito.atLeastOnce()).checkout(libraryItem);

        Mockito.when(lib.getBooks()).thenReturn(Arrays.asList());
        nav.menu(3);
        Mockito.verify(lib, Mockito.atLeastOnce()).returnItem(libraryItem);
    }

    @Test
    public void shouldListAllMovieWhenInputIs4() {
        lib = Mockito.mock(Library.class);
        inputParser = Mockito.mock(InputParser.class);
        ArrayList<Movie> movies = new ArrayList(Arrays.asList(Mockito.mock(Movie.class)));
        Mockito.when(lib.getMovies()).thenReturn(movies);
        nav = new Navigator(lib, inputParser);
        nav.menu(4);
        Mockito.verify(lib, Mockito.times(2)).getMovies();
    }

    @Test
    public void shouldCheckOutMoviesWhenInputIs5AndBookExists() {
        lib =  Mockito.mock(Library.class);
        libraryItem = new Movie("Interstellar", 2014, "Christopher Nolan", 8.9f);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Interstellar");
        Mockito.when(lib.getMovieByTitle("Interstellar")).thenReturn(Optional.of((Movie) libraryItem));
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.of(libraryItem));
        Mockito.when(lib.getMovies()).thenReturn(Arrays.asList((Movie) libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");
        nav.menu(5);
        Mockito.verify(lib, Mockito.atLeastOnce()).checkout(libraryItem);
    }

    @Test
    public void shouldNotCheckOutMovieWhenInputIs5ButInputDoesNotExist() {
        lib =  Mockito.mock(Library.class);
        libraryItem = new Movie("Interstellar", 2014, "Christopher Nolan", 8.9f);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Intellar");
        Mockito.when(lib.getMovieByTitle("Intellar")).thenReturn(Optional.empty());
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.empty());
        Mockito.when(lib.getMovies()).thenReturn(Arrays.asList((Movie) libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");
        nav.menu(5);
        Mockito.verify(lib, Mockito.never()).checkout(libraryItem);
    }

    @Test
    public void shouldReturnMovieWhenInputIs6AndItWasCheckOutPreviously() {
        lib =  Mockito.mock(Library.class);
        libraryItem =  new Movie("Interstellar", 2014, "Christopher Nolan", 8.9f);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Interstellar");
        Mockito.when(lib.getMovieByTitle("Interstellar")).thenReturn(Optional.of((Movie) libraryItem));
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.of(libraryItem));
        Mockito.when(lib.getMovies()).thenReturn(Arrays.asList((Movie) libraryItem));
        Mockito.when(lib.returnItem(libraryItem)).thenReturn(Optional.of(libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");

        nav.menu(5);
        Mockito.verify(lib, Mockito.atLeastOnce()).checkout(libraryItem);

        Mockito.when(lib.getMovies()).thenReturn(Arrays.asList());
        nav.menu(6);
        Mockito.verify(lib, Mockito.atLeastOnce()).returnItem(libraryItem);
    }

    private void givenThatWeWantToCheckOutAExistingBook() {
        lib =  Mockito.mock(Library.class);
        libraryItem = new Book("Harry Potter", "J. K. Rowling", 1997);
        inputParser = Mockito.mock(InputParser.class);

        Mockito.when(inputParser.askForForTitle()).thenReturn("Harry Potter");
        Mockito.when(lib.getBookByTitle("Harry Potter")).thenReturn(Optional.of((Book) libraryItem));
        Mockito.when(lib.checkout(libraryItem)).thenReturn(Optional.of(libraryItem));
        Mockito.when(lib.getBooks()).thenReturn(Arrays.asList((Book) libraryItem));

        nav = new Navigator(lib, inputParser);
        nav.user = new User("000-0001","0001","Sergi Torres", "storres@thoughtworks.com", "959503509");
    }


    private void givenThereIsOneBookInTheLibrary() {
        lib = Mockito.mock(Library.class);
        inputParser = Mockito.mock(InputParser.class);
        ArrayList<Book> books = new ArrayList(Arrays.asList(Mockito.mock(Book.class)));
        Mockito.when(lib.getBooks()).thenReturn(books);
        nav = new Navigator(lib, inputParser);
    }

    private void thenListBooksWillBeCalled() {
        Mockito.verify(lib, Mockito.times(2)).getBooks();
    }

    private void whenWeSelect1() {
        nav.menu(1);
    }

}
