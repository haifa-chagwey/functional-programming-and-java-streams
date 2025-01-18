package com.amigoscode.examples;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

//    Instead of using imperative programming, we can use the distinct method of the Stream API to remove duplicates from a list.
    @Test
    public void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        assertThat(distinct).hasSize(9);
        System.out.println(distinct);
    }

    @Test
    public void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
//        Set<Integer> distinct = new HashSet<>(numbers);
//        The advantage of using Stream API is that you have multiple operators you can use before collecting it to a Set
        Set<Integer> distinct = numbers.stream().collect(Collectors.toSet());
        assertThat(distinct).hasSize(9);
        System.out.println(distinct);
    }
}
