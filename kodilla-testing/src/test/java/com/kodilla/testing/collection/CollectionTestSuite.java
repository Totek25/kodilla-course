package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collections test suite")
class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case begin!");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case end!");
    }

    @DisplayName("When empty list is used, then empty list should be returned")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        ArrayList<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(emptyList);

        List<Integer> expectedResult = new ArrayList<>();

        System.out.println("Testing empty list");

        //Then
        assertEquals(expectedResult, result);
    }

    @DisplayName("When list with odd and even numbers is used, then list with only even numbers should be returned")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        List<Integer> normalList = Arrays.asList(2, 4, 7, 9, 3, 8);

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(normalList);

        System.out.println("Testing normal list");

        List<Integer> expectedResult = Arrays.asList(2, 4, 8);

        //Then
        assertEquals(expectedResult, result);
    }
}
