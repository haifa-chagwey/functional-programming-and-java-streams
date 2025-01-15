package com.haifachagwey.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

public class _Consumer {


    public static void main(String[] args) {
        List<String> emails = List.of(
                "hello@amigoscode.com",
                "foo@amigoscode.com",
                "bar@amigoscode.com"
        );
//        emails.forEach(sendEmailConsumer);
//        emails.forEach(email -> sendEmail(email));
        emails.forEach(_Consumer::sendEmail);
    }

    static Consumer<String> sendEmailConsumer =
            email -> System.out.println("sending email to " + email);
    static void sendEmail(String email) {
        System.out.println("sending email to " + email);
    }
}
