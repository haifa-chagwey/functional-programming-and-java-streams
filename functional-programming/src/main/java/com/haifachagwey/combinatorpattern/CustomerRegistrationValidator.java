package com.haifachagwey.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.haifachagwey.combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static com.haifachagwey.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

@FunctionalInterface
public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

//    ValidationResult apply(Customer customer);

//    An implementation of CustomerRegistrationValidator functional interface

//    static CustomerRegistrationValidator isEmailValid() {
//        CustomerRegistrationValidator customerRegistrationValidator =
//                customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
//        return customerRegistrationValidator;
//    }

    static CustomerRegistrationValidator isEmailValid() {
//        Implementing the CustomerRegistrationValidator functional interface using a lambda expression and returning an instance of this implementation
        CustomerRegistrationValidator customerRegistrationValidator = customer -> {
//            Implementing the apply method
            if (customer.getEmail().contains("@")) {
                return SUCCESS;
            } else {
                return EMAIL_NOT_VALID;
            }
        };
        return customerRegistrationValidator;
    };

    static CustomerRegistrationValidator isPhoneNumberValid() {
//        Implementing the CustomerRegistrationValidator functional interface using a lambda expression and returning an instance of this implementation
        CustomerRegistrationValidator customerRegistrationValidator = customer -> customer.getPhoneNumber().startsWith("+0") ?
//            Implementing the apply method
                SUCCESS : PHONE_NUMBER_NOT_VALID;
        return customerRegistrationValidator;
    }

    static CustomerRegistrationValidator isAdult() {
//        Implementing the CustomerRegistrationValidator functional interface using a lambda expression and returning an instance of this implementation
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
//            The "this" keyword within the interface point to the object of the class that implements the interface.
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
