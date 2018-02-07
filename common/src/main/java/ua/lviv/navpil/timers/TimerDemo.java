package ua.lviv.navpil.timers;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer( "Say hello timer", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Hello");

            }
        }, 10);

        Thread.sleep(1000);
    }
}
