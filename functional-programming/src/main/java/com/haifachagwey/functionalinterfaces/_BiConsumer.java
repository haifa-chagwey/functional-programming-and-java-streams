package com.haifachagwey.functionalinterfaces;

import java.util.function.BiConsumer;

public class _BiConsumer {

    public static void main(String[] args) {

        sendEmailBiConsumer.accept("hello@amigoscode.com", "alexu@gmail.com");

    }

    static BiConsumer<String, String> sendEmailBiConsumer =
            (from, to) ->
                    System.out.printf("sending email from %s to %s%n", from, to);



}
