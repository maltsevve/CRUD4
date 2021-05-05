package com.maltsevve.crud4.view;

import java.util.Scanner;

public class ClientInput {
    private static Scanner scanner;

    public static synchronized Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    private ClientInput() {

    }
}
