package edu.project1;

import java.util.Scanner;

public class ConsolePlayer implements HangmanPlayer {
    private final Scanner scanner;

    public ConsolePlayer() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void displayInfo(String msg) {
        System.out.println(msg);
    }
}
