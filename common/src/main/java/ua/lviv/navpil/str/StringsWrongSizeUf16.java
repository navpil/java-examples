package ua.lviv.navpil.str;

public class StringsWrongSizeUf16 {

    public static void main(String[] args) {
        String x = "\uD834\uDF29";
        System.out.println(x);

        System.out.println(x.length());

        System.out.println(x.substring(0, 1));

        String hello = null;

        System.out.println((hello));
    }
}
