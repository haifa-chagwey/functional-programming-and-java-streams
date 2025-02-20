package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> collect = MockData.getCars().stream()
                .collect(Collectors.groupingBy(car -> car.getMake()));
        collect.forEach((make, cars) -> {
            System.out.println("Make: " + make);
            cars.forEach(car -> System.out.println(car));
            System.out.println("*****************");
        });

    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );
//        Map<String, Long> collect = names.stream()
//                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<String, Long> collect = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }


}