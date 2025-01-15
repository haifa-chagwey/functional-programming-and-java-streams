package com.haifachagwey.functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getUrlSupplier.get());
    }

    static Supplier<List<String>> getUrlSupplier =
            () -> {
                // logic
                return List.of("https://amigoscode.com");
            };

    static String getUrl() {
        return "https://amigoscode.com";
    }

}
