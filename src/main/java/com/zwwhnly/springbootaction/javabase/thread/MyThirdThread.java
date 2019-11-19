package com.zwwhnly.springbootaction.javabase.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyThirdThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(6 * 1000);
        return new Random().nextInt();
    }
}
