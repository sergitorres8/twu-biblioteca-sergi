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

    public String askForTitle() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public String askForLoginNumber() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.matches("\\d{3}-\\d{4}"))
            return input;
        return null;
    }

    public String askForForPassword() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
