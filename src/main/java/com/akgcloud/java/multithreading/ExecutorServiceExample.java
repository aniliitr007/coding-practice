package com.akgcloud.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    private ExecutorService threadPool = null;

    private ExecutorServiceExample() {
        threadPool = Executors.newCachedThreadPool();
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        ExecutorServiceExample ex = new ExecutorServiceExample();
        Future<String> fut = ex.getThreadPool().submit(new Callable<String>() {
            public String call() throws Exception {
                return "Excuter Service Called";
            }
        });

        System.out.println(fut.get());

    }

}
