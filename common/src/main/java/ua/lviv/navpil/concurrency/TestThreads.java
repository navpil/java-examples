package ua.lviv.navpil.concurrency;

import java.util.concurrent.Executors;

public class TestThreads {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().submit(() -> {while (true) {}});
    }
}
