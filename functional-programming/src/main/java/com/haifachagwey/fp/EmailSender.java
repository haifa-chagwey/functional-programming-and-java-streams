package com.haifachagwey.fp;

@FunctionalInterface
public interface EmailSender {

//    void send();
    boolean send(String from, String to );
}
