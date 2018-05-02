package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        System.out.println(listOfBooks());
    }

    public static String welcomeMessage() {
        return "Dear client, Welcome to the library application";
    }

    public static String listOfBooks() {
        return "Harry Potter Y El Cadiz De Fuego\nEl Señor de los anillos";
    }
}
