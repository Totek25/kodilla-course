package com.kodilla.testing.weather.stub;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }

        return resultMap;
    }

    public double calculateAverage() {
        double sum = 0;
//        System.out.println(temperatures.getTemperatures().values());
//        ArrayList<Double> x = new ArrayList<>(temperatures.getTemperatures().values());
//        Collections.sort(x);
//        System.out.println(x.get(x.size() / 2));
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum = BigDecimal.valueOf(sum + temperature.getValue()).setScale(2, RoundingMode.DOWN).doubleValue();
        }
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedian() {
        Collection<Double> temperatures = this.temperatures.getTemperatures().values();
        if (temperatures.isEmpty()) {
            return 0;
        }
        List<Double> sortableTemperatures = new ArrayList<>(temperatures);
        Collections.sort(sortableTemperatures);
        if (isEven(sortableTemperatures.size())) {
            // 0    1    2    3    4    5
            // 23.1 24.8 25.2 25.5 26.2 27.3
            Double leftElement = sortableTemperatures.get(sortableTemperatures.size() / 2 - 1); // element 6/2-1=2: 25.2
            Double rightElement = sortableTemperatures.get(sortableTemperatures.size() / 2); // element 6/2=3: 25.5
            return (leftElement + rightElement) / 2;
        }
        return sortableTemperatures.get(sortableTemperatures.size() / 2);
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }
}

