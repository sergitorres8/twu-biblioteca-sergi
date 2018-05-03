package com.twu.biblioteca;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();

        System.out.println(welcomeMessage());
        int n = menu.chooseOption();
        menu.optionChosen(n);

    }

    public static String welcomeMessage() {
        return "Dear client, Welcome to the library application.\n";
    }

}

