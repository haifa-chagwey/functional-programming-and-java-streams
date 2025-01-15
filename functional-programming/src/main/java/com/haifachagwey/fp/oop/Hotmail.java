package com.haifachagwey.fp.oop;

public class Hotmail implements EmailSender {

    @Override
    public void send() {
        System.out.println("Sending email with Hotmail");
    }
}
