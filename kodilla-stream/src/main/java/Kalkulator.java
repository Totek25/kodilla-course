package com.kodilla;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calculator = new calculator();
        System.out.println(calculator.add(6, 10));
        System.out.println(calculator.sub(6, 10));
    }
}
