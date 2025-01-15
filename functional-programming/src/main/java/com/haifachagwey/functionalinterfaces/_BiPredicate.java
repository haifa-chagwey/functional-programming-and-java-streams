package com.haifachagwey.functionalinterfaces;

import java.util.function.BiPredicate;

public class _BiPredicate {

    public static void main(String[] args) {
//        BiPredicate<T,U> Represents a predicate (boolean-valued function) of two arguments.

        BiPredicate<String, String> areBothEqual = String::equals;
        BiPredicate<String, String> areBothEqual2 = (string1, string2) -> {
            System.out.println("lambda");
            return string1.equals(string2);
        };

    }
}
