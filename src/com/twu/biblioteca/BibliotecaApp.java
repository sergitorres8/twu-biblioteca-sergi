package com.twu.biblioteca;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        System.out.println(welcomeMessage());
        menu.createBookList();
        menu.optionsAvailable();
        int option = menu.checkInput();
        menu.optionChosen(option);
        while (option != 0) {
            menu.optionsAvailable();
            option = menu.checkInput();
            menu.optionChosen(option);
        }

    }

    public static String welcomeMessage() {
        return "Dear client, Welcome to the library application.\n";
    }

}

