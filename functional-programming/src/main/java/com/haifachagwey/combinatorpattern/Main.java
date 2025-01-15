package com.haifachagwey.combinatorpattern;

import java.time.LocalDate;

import static com.haifachagwey.combinatorpattern.CustomerRegistrationValidator.*;
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Alice",
                "alice@gmail.com",
                "+0123456789",
                LocalDate.of(2000, 1, 1));
//        System.out.println(new CustomerValidatorService().isValid(customer));
//        If valid we can store customer in db

//        Using combinator pattern
        CustomerRegistrationValidator customerRegistrationValidator =
                CustomerRegistrationValidator.isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult());
        ValidationResult result = customerRegistrationValidator.apply(customer);

//        ValidationResult result =
//                CustomerRegistrationValidator.isEmailValid()
//                        .and(isPhoneNumberValid())
//                        .and(isAdult()).apply(customer);
        System.out.println(result);
        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
