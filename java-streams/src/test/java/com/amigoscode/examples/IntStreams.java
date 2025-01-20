package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("With for");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("With IntStream exclusive");
//        IntStream.range(0, 10).forEach(value -> System.out.println(value));
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("With IntStream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
//        We should not use IntStream.rangeClosed(0, people.size()) because it will throw IndexOutOfBoundsException
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size()).forEach(index -> {
            System.out.println(people.get(index));
        });
    }

    @Test
    public void intStreamIterate() {
        IntStream.iterate(0, i -> i + 2)
                .limit( 5)
                .forEach(System.out::println); // 0 2 4 6 8
//        DoubleStream (Stream for double)
//        LongStream (Stream for long)
//        Stream.of()
    }
}

