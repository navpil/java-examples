package ua.lviv.navpil.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedStreamsDemo {

    public static void main(String[] args) throws IOException, InterruptedException {


        PipedInputStream is = new PipedInputStream();
        PipedOutputStream os = new PipedOutputStream(is);


        Runnable runnable = () -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            try {
                System.out.println("Try this - 1");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("Try this - 2");
                reader.close();
                System.out.println("Try this - 3");
            } catch (IOException ignore) {
            }
            System.out.println("Try this - 4");
        };
//        new Thread(runnable).start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnable);


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        writer.write("Hello,\n");
        writer.write("It's me\n");

        writer.flush();

        os.close();
        System.out.println("Finished writing");
        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MINUTES);
    }

    private static Callable<?> asCallable(Runnable runnable) {
        return () -> {runnable.run();return null;};
    }

}
