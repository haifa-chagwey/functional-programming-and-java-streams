package com.haifachagwey.functionalinterfaces;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        String email = "hello@amigoscode.com";
        System.out.println(isValidEmailPredicate.test(email));
        System.out.println( isValidEmailPredicate.and(containsDotPredicate).test(email));
        System.out.println( isValidEmailPredicate.or(containsDotPredicate).test(email));
    }

    static Predicate<String> isValidEmailPredicate =
            email -> email.contains("@");
    static Predicate<String> containsDotPredicate =
            email -> email.contains(".");
}
