package com.akgcloud.java.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void testProducerConsumer() throws InterruptedException {
        final Processor process = new Processor();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }

    public static void testExecutorService() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new CallableResult());
        executor.shutdown();
        try {
            System.out.println("Result duration : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // App.testExecutorService();
        App.testProducerConsumer();
    }

}
