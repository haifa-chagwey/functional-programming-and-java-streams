package com.haifachagwey.callbacks;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        hello("John", "Doe",value -> System.out.println("No lastName provided for " + value)); // John Doe
        System.out.println("-----");
        hello("John", null, value -> System.out.println("No lastName provided for " + value)); // John No lastName provided

//        Without taking any arguments
        hello2("John", "Doe", () -> System.out.println("No lastName provided"));
        hello2("John", null, () -> System.out.println("No lastName provided")); // John Doe
// John Doe
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

//    Callbacks in Javascript

//        function hello(firstName, lastName, callback) {
//            console.log(firstName);
//            if (lastName) {
//                console.log(lastName);
//            } else {
//                callback;
//            }
//        }

//    hello("John", "Doe", function() { console.log("No lastName provided"); }); // John Doe
//    hello("John", null, function() { console.log("No lastName provided"); }); // John No lastName provided


}
