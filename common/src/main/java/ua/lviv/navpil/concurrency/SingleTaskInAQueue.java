package ua.lviv.navpil.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleTaskInAQueue {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        executorService.submit(() -> {wwait(1); System.out.println("Hello, world");wwait(1);});
        Future<?> submit = executorService.submit(() -> {
            wwait(1);
            System.out.println("Hello, world 2");
        });
        executorService.submit(() -> {wwait(1); System.out.println("Hello, world 3");});
        executorService.submit(() -> {wwait(1); System.out.println("Hello, world 4");});
        wwait(3);

//        submit.get();
//        System.out.println(executorService.getActiveCount());
        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS))
            System.err.println("Threads didn't finish in 60000 seconds!");


    }

    private static void wwait(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
