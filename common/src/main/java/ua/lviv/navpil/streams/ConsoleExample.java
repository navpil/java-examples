package ua.lviv.navpil.streams;

import java.io.Console;
import java.util.Arrays;

public class ConsoleExample {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        System.out.println("Console found");

        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password");

        if (verify(login, oldPassword)) {
            boolean match;
            do {
                char[] newPassword1 = c.readPassword("Enter your new password: ");
                char[] newPassword2 = c.readPassword("Enter your new password again: ");
                match = Arrays.equals(newPassword1, newPassword2);
                if (match) {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                } else {
                    c.format("Do not match, try again.%n");
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (!match);

        }
        Arrays.fill(oldPassword, ' ');
    }

    private static void change(String login, char[] newPassword1) {

    }

    private static boolean verify(String login, char[] oldPassword) {
        return true;

    }
}
