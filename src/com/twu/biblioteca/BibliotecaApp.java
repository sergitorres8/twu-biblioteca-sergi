package com.twu.biblioteca;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MainMenu menu = new MainMenu();

        welcomeMessage();

        menu.chooseOption();
        System.out.println("Select an option: ");
        int n = reader.nextInt();
        menu.optionChosen(n);
        reader.close();


    }

    public static void welcomeMessage() {
        System.out.println("Dear client, Welcome to the library application.\n");
    }

}

