package com.haifachagwey.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional.ofNullable(null);
//        Person person = null;
        Person person = new Person("Test");
        Optional.ofNullable(person)
                .map(Person::getName)
                .ifPresent(System.out::println);

    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
