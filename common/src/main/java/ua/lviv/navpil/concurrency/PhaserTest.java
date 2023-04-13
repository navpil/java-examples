package ua.lviv.navpil.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            phaser.register();
            executorService.submit(new MyTask("" + i + ") task", phaser));
        }
        executorService.shutdown();
        System.out.println("---WAITING---");
        phaser.arriveAndAwaitAdvance();
        System.out.println("---DONE---");
    }


    public static class MyTask implements Runnable {

        private final String name;
        private final Phaser phaser;
        private Random random;

        public MyTask(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(name + i);
                    random = new Random();
                    try {
                        Thread.sleep(500 + random.nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                phaser.arriveAndDeregister();
            }

            System.out.println("" + name + "OUT");

        }
    }

}
