package ua.lviv.navpil.lambdas;

import org.jetbrains.annotations.NotNull;

public class CommandAndRunnable {

    public static void main(String[] args) {

        execute(getCommandImpl2()::run);

    }

    @NotNull
    private static CommandImpl2 getCommandImpl2() {
        return new CommandImpl2();
    }


    private static void execute(Command runnable) {
        runnable.exec();
    }

    public interface Command {
        void exec();
    }

    public static class CommandImpl implements Command {
        @Override
        public void exec() {
            System.out.println("Hello world");
        }
    }

    public static class CommandImpl2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello world");
        }
    }
}
