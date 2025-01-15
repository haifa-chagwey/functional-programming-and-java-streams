package com.haifachagwey;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("I just implemented the Runnable Functional Interface.")).start();
    }

}