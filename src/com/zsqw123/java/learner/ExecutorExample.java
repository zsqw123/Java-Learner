package com.zsqw123.java.learner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    static Runnable runnable0 = () -> {
        System.out.println("from Runable0");
    };

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.shutdown();
        executor.execute(runnable0);
//        executor.shutdownNow();
        System.out.println(1);

    }

    static Runnable runnable = () -> {
        System.out.println(2);
    };
}
