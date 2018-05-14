package com.twu.biblioteca;

import java.util.Scanner;

public class InputParser {
    private Scanner scanner;

//    public InputParser() {
//        scanner = new Scanner(System.in);
//    }


    public int askForNumber(){
        scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public String askForForTitle() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
