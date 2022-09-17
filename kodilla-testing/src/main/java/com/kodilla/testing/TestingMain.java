package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Test dodawania");

        int result = calculator.add(2,4);

        if (result == 6) {
            System.out.println("Wynik jest OK");
        } else {
            System.out.println("Wynik nie jest OK");
        }

        System.out.println("Test odejmowania");

        result = calculator.sub(2,4);

        if (result == -2) {
            System.out.println("Wynik jest OK");
        } else {
            System.out.println("Wynik nie jest OK");
        }
    }
}
