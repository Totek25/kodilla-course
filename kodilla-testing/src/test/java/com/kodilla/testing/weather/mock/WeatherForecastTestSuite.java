package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @Test
    void testCalculateForecastWithStub() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);

    }

    @Test
    void testCalculateAverage() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double average = weatherForecast.calculateAverage();

        //Then
        assertEquals(25.56, average);
    }

    @Test
    void testCalculateMedian() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double median = weatherForecast.calculateMedian();

        //Then
        assertEquals(25.5, median);
    }

    @Test
    void testCalculateMedianWithEvenNumberOfTemperatures() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        when(temperaturesMock.getTemperatures()).thenReturn(Map.of(
                "Rzeszow", 25.5,
                "Krakow", 26.2,
                "Tarnow", 23.1,
                "Wroclaw", 24.8,
                "Lodz", 27.3,
                "Warszawa", 25.2
        ));

        //When
        double median = weatherForecast.calculateMedian();

        //Then
        assertEquals(25.35, median);
    }

    @Test
    void testCalculateMedianWithEmptyListOfTemperatures() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        when(temperaturesMock.getTemperatures()).thenReturn(Map.of());

        //When
        double median = weatherForecast.calculateMedian();

        //Then
        assertEquals(0.0, median);
    }
}

