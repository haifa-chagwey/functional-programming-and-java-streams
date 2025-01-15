package com.haifachagwey.fp.oop;

public class Main {
    public static void main(String[] args) {

        EmailSender emailSender = new Gmail();
        emailSender.send();

    }

}