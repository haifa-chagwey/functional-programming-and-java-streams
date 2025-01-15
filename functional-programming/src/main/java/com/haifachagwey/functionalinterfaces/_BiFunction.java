package com.haifachagwey.functionalinterfaces;

import java.util.function.BiFunction;

public class _BiFunction {

    public static void main(String[] args) {

        System.out.println(personMapper("Jamila", 18));

        Person jamila = personMapperBiFunc.apply("Jamila", 18);
        System.out.println(jamila);
        System.out.println(multiplyByBiFunction.apply(2, 3));

    }
//    static BiFunction<String, Integer, Person> personMapperBiFunc = (name, age) -> new Person(name, age);

    static BiFunction<String, Integer, Person> personMapperBiFunc = Person::new;
    static BiFunction<Integer, Integer, Integer> multiplyByBiFunction = (number, numberToMultiplyBy) -> number * numberToMultiplyBy;

    record Person(String name, int age) {}

    static Person personMapper(String name, int age) {
        return new Person(name, age);
    }
}
