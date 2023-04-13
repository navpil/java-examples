package ua.lviv.navpil.i18n;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Codec {

    public static final String UA = "Привіт, як у тебе справи";

    public static void main(String[] args) {
        showBytes(StandardCharsets.UTF_8);
        showBytes(StandardCharsets.UTF_16);
        showBytes(StandardCharsets.US_ASCII);
        showBytes(Charset.forName("KOI8-U"));
        showBytes(Charset.forName("windows-1251"));
    }

    private static void showBytes(Charset cs) {
        System.out.println("Charset: " + cs);
        byte[] bytes = UA.getBytes(cs);
        System.out.println("\t" + Arrays.toString(bytes));
        System.out.println("\t" + new String(bytes, cs));


    }
}
