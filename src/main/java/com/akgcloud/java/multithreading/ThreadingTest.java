package com.akgcloud.java.multithreading;

public class ThreadingTest {

    public static void main(String[] args) {
        MyRunnable thread1 = new MyRunnable();
        MyRunnable thread2 = new MyRunnable();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        //Thread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
