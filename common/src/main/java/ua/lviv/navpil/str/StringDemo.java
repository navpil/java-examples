package ua.lviv.navpil.str;

import java.text.MessageFormat;

public class StringDemo {

    public static void main(String[] args) {
        System.out.printf("%2$04d:%1$s", "two", 2);
        System.out.println();

        Object[] arg = null;

        System.out.println(MessageFormat.format("Some message <{0}>, <{1}>, <{2}>", arg));
    }

}
