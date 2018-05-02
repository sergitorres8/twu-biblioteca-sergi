package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void welcomeMessageTest() {

        assertEquals( "Dear client, Welcome to the library application", BibliotecaApp.welcomeMessage());
    }

    @Test
    public void listOfBooksTest() {
        assertEquals("Harry Potter Y El Cadiz De Fuego\nEl Señor de los anillos", BibliotecaApp.listOfBooks());
    }
}
