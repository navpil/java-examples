package ua.lviv.navpil;

public class WTF {

    public static void main(String[] args) {
        final int i = 0;
        char x = 'X';
//        System.out.println(true ? x : 0);

        m(i, x);
    }

    private static void m(int i, char x) {
        System.out.println(false ? i : x);
        run(() -> System.out.println(false ? i : x));
    }

    private static void run(Runnable r) {
        r.run();
    }
}
