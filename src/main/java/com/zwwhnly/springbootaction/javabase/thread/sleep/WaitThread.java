package com.zwwhnly.springbootaction.javabase.thread.sleep;

public class WaitThread implements Runnable {
    private Service service;

    public WaitThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.mWait();
    }

    public Service getService() {
        return service;
    }
}
