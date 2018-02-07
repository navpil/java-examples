package ua.lviv.navpil.concurrency;

import java.util.ArrayList;

public class TestSynchronized {

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        TestSynchronized t = new TestSynchronized();

        ArrayList<Thread> threads = new ArrayList<>();


        threads.add(t.runAndWait("name1"));
        threads.add(t.runAndWait("name2"));

        threads.add(t.runNotifyAllAndExit("notify"));

        for (Thread thread : threads) {
            thread.join();
        }

    }

    private Thread runNotifyAllAndExit(String name) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Before in notify");
                lock.notifyAll();
                System.out.println("After notify in lock");
            }
        }, name);
        thread.start();
        return thread;
    }

    private Thread runAndWait(String name) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Before wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("After wait");
            }
        }, name);
        thread.start();
        return thread;
    }

}
