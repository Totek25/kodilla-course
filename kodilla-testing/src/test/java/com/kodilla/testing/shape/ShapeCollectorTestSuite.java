package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Collector Test Suite")
class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for square")
    class TestSquare {

        @Test
        public void testAddSquare() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Square square = new Square(2);
            //When
            collector.addFigure(square);
            //Then
            assertEquals(square, collector.getFigure(0), "shape is returned from collection");
            //And
            assertEquals("square", collector.showFigures());
        }

        @Test
        public void testRemoveSquare() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Square square = new Square(3);
            collector.addFigure(square);
            //When
            collector.removedFigure(square);
            //Then
            assertNull(collector.getFigure(0), "shape is not in collection anymore");
            //And
            assertEquals("", collector.showFigures());
        }
    }

    @Nested
    class TestGettingFigures {

        @Test
        public void testGettingFigureOutOfBounds() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(new Circle(4));

            int nThatIsTooHigh = 1;
            //When
            Shape result = collector.getFigure(nThatIsTooHigh);
            //Then
            assertNull(result);
        }

        @Test
        public void testGettingNegativeIndex() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(new Circle(4));

            int nThatIsNegative = -10;
            //When
            Shape result = collector.getFigure(nThatIsNegative);
            //Then
            assertNull(result);
        }
    }

    @Nested
    class TestPrintingFigures {

        @Test
        public void testMultipleFiguresPrinting() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(new Circle(4));
            collector.addFigure(new Triangle(4,5));
            collector.addFigure(new Square(2));
            //When
            String result = collector.showFigures();
            //Then
            assertEquals("circle, triangle, square", result);
        }
    }
}