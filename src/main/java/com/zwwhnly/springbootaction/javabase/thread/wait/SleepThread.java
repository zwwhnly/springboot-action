package com.zwwhnly.springbootaction.javabase.thread.wait;

public class SleepThread implements Runnable {
    private Service service;

    public SleepThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.mSleep();
    }

    public Service getService() {
        return service;
    }
}
