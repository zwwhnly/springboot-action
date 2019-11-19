package com.zwwhnly.springbootaction.javabase.thread;

public class SaleTicketThread implements Runnable {
    private int quantity = 10;

    @Override
    public void run() {
        while (quantity > 0) {
            System.out.println(quantity-- + " is saled by " +
                    Thread.currentThread().getName());
        }
    }
}
