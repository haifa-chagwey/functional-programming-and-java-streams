package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void streams() {
//        *** Create a stream from a list ***
        List<String> names = List.of("Amigoscode", "Alex", "Zara");
        Stream<String> stream = names.stream();
//        Or
        Stream<String> stream2 = Stream.of("Amigoscode", "Alex", "Zara");
        long count = stream.limit(2).map(null).sorted(null).dropWhile(null)
                .count();
//        *** Create a stream from an array ***
        String[] namesArray = {"Amigoscode", "Alex", "Zara"};
        Stream<String> stream3 = Arrays.stream(namesArray);
    }
}
