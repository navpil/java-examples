package ua.lviv.navpil;

import java.io.IOException;

public class WildCode {

    public static void main(String[] args) throws IOException {
        System.out.println("1");
        SecDemo.doPriviledged();
        System.out.println("2");
        SecDemo.justDo();
        System.out.println("3");
    }
}
