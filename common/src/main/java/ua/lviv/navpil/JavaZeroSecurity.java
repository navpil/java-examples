package ua.lviv.navpil;

import java.io.FileInputStream;
import java.io.IOException;

public class JavaZeroSecurity {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("Beanarchive.xml");

        System.out.println(in.read());

        in.close();

    }
}
