package com.akgcloud.java.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableResult implements Callable<Integer> {

    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        Random random = new Random();
        int duration = random.nextInt(1000);
        Thread.sleep(duration);
        return duration;
    }

}
