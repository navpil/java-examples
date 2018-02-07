package ua.lviv.navpil.i18n;

import java.util.Arrays;

public class CodePointsDemo {

    public static void main(String[] args) {
        String s = "a: \uD83D\uDCF6\u0061\u0301\u0065";
        System.out.println(Character.codePointAt(s, 0));
        System.out.println(Arrays.toString(Character.toChars(Character.codePointAt(s, 0))));
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println(s);

        char accent = '\u0301';
        System.out.println(accent);

        for (int i = -4; i < 5; i++) {

            System.out.println("" + (char)(accent + i) + "\uD83D\uDCF6");
        }


        System.out.println(new StringBuilder(s).reverse().toString());

    }
}
