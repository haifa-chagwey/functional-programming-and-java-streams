package com.haifachagwey.fp;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

/*        Implementing the EmailSender interface using Anonymous Inner Class  */

//        EmailSender gmailSender = new EmailSender() {
////            Implementing the send method
//            @Override
//            public void send() {
//                System.out.println("Sending email with Gmail server");
//            }
//        };

//        EmailSender hotmailSender = new EmailSender() {
//            @Override
//            public void send() {
//                System.out.println("Sending email with Gmail server");
//            }
//        };

/*        gmailSender is an instance of functional implementations of the EmailSender interface, same for hotmailSender      */

//        gmailSender.send();
//        hotmailSender.send();

//        ************************************************************************************************

/*        Implementing the EmailSender Interface using lambda expression        */

//        EmailSender gmailSender = () -> System.out.println("Sending email with Gmail server");
//        EmailSender hotmailSender = () -> System.out.println("Sending email with Hotmail server");
//        gmailSender.send();
//        hotmailSender.send();

        EmailSender gmailSender = (from, to) -> {
            // Implementing the send method
            System.out.println("Sending email with Gmail server");
            return true;
        };

        EmailSender hotmailSender = (from, to) -> {
            // Implementing the send method
            System.out.println("Sending email with Hotmail server");
            return false;
        };

        System.out.println(gmailSender.send("from@gmail.com", "to@gmail.com"));
        System.out.println(hotmailSender.send("from@gmail.com", "to@gmail.com"));

    }
}
