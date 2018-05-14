package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Printer output = new Printer();
        Library library = new Library();
        Navigator nav = new Navigator(library);
        output.welcomeMessage();

        if(nav.loginUser()) {
            int action = nav.selectAnActionFromMenu();
            while (action != 0) {
                nav.menu(action);
                action = nav.selectAnActionFromMenu();
            }
        }
        else
            System.exit(0);
    }
}
