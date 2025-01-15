package com.haifachagwey.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.haifachagwey.streams._Stream.Gender.FEMALE;
import static com.haifachagwey.streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );
        people.stream()
//                We implemented the Consumer interface, and we have created an object from this implementation
//                and pass it as an argument to the map function using the lambda expression
                .map(person -> person.gender)
//                Removing duplicates
                .collect(Collectors.toSet())
//                .forEach(gender -> System.out.println(gender));
                .forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> stringToIntFunction = String::length;
        people.stream()
                .map(personStringFunction)
                .mapToInt(stringToIntFunction)
                .forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", Gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
