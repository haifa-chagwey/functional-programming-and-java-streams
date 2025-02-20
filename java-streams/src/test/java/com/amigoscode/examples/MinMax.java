package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
//        System.out.println(Collections.min(numbers));

        numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println(numbers.stream().min(Integer::compareTo).get());
        System.out.println("min = " + numbers.stream().min(Comparator.naturalOrder()).get());
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
//        Imperative way
//        Integer max = numbers.get(0);
//        for (Integer number : numbers) {
//            if (number > max) {
//                max = number;
//            }
//        }
//        System.out.println("max = " + max);

//        Declarative way
        System.out.println(numbers.stream().max(Integer::compareTo).get());
//        System.out.println("max = " + numbers.stream().max(Comparator.naturalOrder()).get());
    }
}
