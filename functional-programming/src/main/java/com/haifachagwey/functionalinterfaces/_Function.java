package com.haifachagwey.functionalinterfaces;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Function {

//        Function<T,R> Represents a function that accepts one argument and produces a result.

    public static void main(String[] args) {

//        Imperative approach
        System.out.println(incrementByOne(1));

//        Declarative approach (Functional programming style)
        System.out.println(incrementByOneFunc.apply(1));

        List<Integer> integers = Stream.of(1, 2, 3)
                .map(_Function::incrementByOne)
                .collect(Collectors.toList());
        System.out.println(integers);

        System.out.println(combinedFunction.apply(1));
    }

    static int incrementByOne (int n) {
        return n + 1;
    }

//        Defining an implementation of the Function interface then returning an instance of this implementation
    static Function<Integer, Integer> incrementByOneFunc =
            n -> n + 1;

    static Function<Integer, Integer> doubleFunc =
            n -> n * 2;

    static Function<Integer, Integer> combinedFunction =
            incrementByOneFunc.andThen(doubleFunc);

}
