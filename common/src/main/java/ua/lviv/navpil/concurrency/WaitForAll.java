package ua.lviv.navpil.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaitForAll {

//    private AtomicBoolean shouldProcess = new AtomicBoolean(false);
    private final Object lock = new Object();
    private volatile boolean shouldProcess;

    public void updateCredentials() {
        shouldProcess = true;
        synchronized (lock) {
            if (shouldProcess){
                doSomething();
            }
            shouldProcess = false;
        }

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this::updateCredentials, 30, 30, TimeUnit.MINUTES);
    }

    public void doSomething() {
//        Thread.sleep(100);
        System.out.println("After thread");
    }
}
