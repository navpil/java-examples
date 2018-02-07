package ua.lviv.navpil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class SecDemo {

    public static void main(String[] args) throws IOException {
        doPriviledged();
        justDo();
    }

    public static void justDo() throws IOException {
        System.out.println(Files.readAllLines(Paths.get("Beanarchive.xml")));
    }

    public static void doPriviledged() {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            try {
                justDo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
