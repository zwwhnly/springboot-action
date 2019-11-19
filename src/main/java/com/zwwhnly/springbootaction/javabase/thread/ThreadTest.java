package com.zwwhnly.springbootaction.javabase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {

        System.out.println("主线程开始执行,当前线程名称:" +
                Thread.currentThread().getName());

        /*Thread firstThread = new Thread(new MyFirstThread());

        Runnable target = new MySecondThread();
        Thread secondThread = new Thread(target);

        firstThread.start();
        secondThread.start();*/

        Callable<Integer> callable = new MyThirdThread();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("futureTask.isDone() return:" + futureTask.isDone());

            System.out.println(futureTask.get());

            System.out.println("futureTask.isDone() return:" + futureTask.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行结束,当前线程名称:" +
                Thread.currentThread().getName());
    }
}
