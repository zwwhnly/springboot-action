package com.zwwhnly.springbootaction.javabase.thread.threadlocal;

public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("thredOne remove after:" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("thredTwo remove after:" + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }

    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }
}
