package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (isNotOdd(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private boolean isNotOdd(Integer number) {
        return number % 2 == 0;
    }
}
