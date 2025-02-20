package com.amigoscode.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformationsWithFlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach
    void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
//        [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

//        Im

        List<String> allNames = new ArrayList<>();
        arrayListOfNames
//                .forEach(names -> allNames.addAll(names));
                .forEach(allNames::addAll);
        System.out.println(allNames);
    }

    @Test
    public void withFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

        Function<List<String>, Stream<? extends String>> listStreamFunction = list -> list.stream();
        List<String> allNames = arrayListOfNames
                .stream()
                .flatMap(listStreamFunction)
                .collect(Collectors.toList());
        System.out.println(allNames);

//        List<String> allNames = arrayListOfNames
//                .stream()
//                .flatMap(list -> list.stream())
//                .collect(Collectors.toList());
//        System.out.println(allNames);

//        List<String> allNames = arrayListOfNames
//                .stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//        System.out.println(allNames);
    }

    @Test
    public void flatMapWithOptionals() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Amigos"),
                Optional.of("Code")
        );
        System.out.println(optionals);
        Function<Optional<String>, Stream<? extends String>> stream = optional -> optional.stream();
        List<String> list = optionals.stream()
                .flatMap(stream)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}