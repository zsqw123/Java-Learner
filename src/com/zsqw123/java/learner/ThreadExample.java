package com.zsqw123.java.learner;

public class ThreadExample {
    static final Runnable runnable0 = () -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("from Runable0");
    };
    static final Runnable runnable1 = () -> {
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("from Runable1");
    };

    public static void main(String[] args) {
        Thread thread = new Thread(runnable0);
        Thread thread1 = new Thread(runnable1);
        thread.start();
        thread1.start();
    }
}
