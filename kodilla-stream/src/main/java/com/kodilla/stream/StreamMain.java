package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.Calculator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.MathExpression;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Ala ma kota", poem -> poem.toUpperCase(Locale.ROOT));
        poemBeautifier.beautify("Ala ma psa" , String::toLowerCase);
        poemBeautifier.beautify("Kotek na płocie" , poem -> poem.replace("Kotek", "Pies"));
        poemBeautifier.beautify("Auta klasy" , poem -> poem + " ABC");
        poemBeautifier.beautify("Ala ma psa " , poem -> poem.repeat(5));
        poemBeautifier.beautify("Ala ma psa" , poem -> new StringBuilder(poem).reverse().toString());



        // SUM
        expressionExecutor.executeExpression(10, 5, new MathExpression() {
            @Override
            public double calculateExpression(double a, double b) {
                return a + b;
            }
        });
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, Calculator::sum);

        // SUB
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);

        // MUL
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);

        // DIV
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
    }
}
