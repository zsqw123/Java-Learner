package com.zsqw123.java.learner;

public class ThreadAwait {
    static final Object monitor = new Object();
    static final Object monitor1 = new Object();
    static boolean a = true;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() + " lockTest-start");
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis() + " task1 done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                try {
                    while (a) {
                        monitor.wait();
                    }
                    System.out.println(System.currentTimeMillis() + " tasks done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (monitor) {
                try {
                    Thread.sleep(1300);
                    System.out.println(System.currentTimeMillis() + " task2 done");
                    a = false;
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//        threadAwait.method0();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadAwait.method1();
    }
}
