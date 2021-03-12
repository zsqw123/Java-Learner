package com.zsqw123.java.learner;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedThread {
    static volatile AtomicInteger a = new AtomicInteger(0);
    static int b = 0;

    static synchronized void plus() {
        b++;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                plus();
//                a.getAndIncrement();
            }
            System.out.println(b);
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                plus();
//                a.getAndIncrement();
            }
            System.out.println(b);
        }).start();
    }
}
