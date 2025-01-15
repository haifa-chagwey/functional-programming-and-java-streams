package com.haifachagwey.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String> upperCase = String::toUpperCase;

        Function<String, String> upperCase2 = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name is blank");
            return name.toUpperCase();
        };

        BiFunction<String, String, String> upperCase3 = (name, lastName) -> {
            if (name.isBlank() || lastName.isBlank()) throw new IllegalArgumentException("Name is blank");
            return name.toUpperCase() + " " + lastName.toUpperCase();
        };

        upperCase3.apply("John", "Doe");
        upperCase3.apply("John", null);
    }
}
