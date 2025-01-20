package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();

//        int count = 0;
//        for (Car car: MockData.getCars()) {
//            if (car.getMake().equalsIgnoreCase("Ford")) {
//                count++;
//            }
//        }
//        System.out.println(count);

//        AtomicInteger count = new AtomicInteger();
//        MockData.getCars().forEach(car -> {
//            if (car.getMake().equalsIgnoreCase("Ford")) {
//                count.getAndIncrement();
//            }
//        });
//        System.out.println(count);


        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .count();
        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        double min = MockData.getCars().stream()
                .mapToDouble(car -> car.getPrice())
                .min()
                .orElse(0);
        System.out.println(min);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double max = MockData.getCars().stream()
                .mapToDouble(car -> car.getPrice())
                .max()
                .orElse(0);
        System.out.println(max);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        double avg = MockData.getCars().stream()
                .mapToDouble(car -> car.getPrice())
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = MockData.getCars().stream()
                .mapToDouble(car -> car.getPrice())
                .sum();

//        System.out.println(sum); // Big number
        System.out.println(BigDecimal.valueOf(sum));
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(BigDecimal.valueOf(statistics.getAverage()));
    }

}