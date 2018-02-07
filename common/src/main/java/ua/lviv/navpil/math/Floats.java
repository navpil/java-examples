package ua.lviv.navpil.math;

public class Floats {

    public static void main(String[] args) {
        float f = 7.0f/3.0f;
        float ffd = (float)(7.0/3.0);
        double d = 7.0/3.0;
        double dff = 7.0f/3.0f;
        double dff2 = (double)(7.0f/3.0f);

        System.out.println("Comparing float");
        System.out.println(f == ffd);
        System.out.println(f == d);
        System.out.println(f == dff);
        System.out.println(f == dff2);

        System.out.println("Comparing float from double");
        System.out.println(ffd == d);
        System.out.println(ffd == dff);
        System.out.println(ffd == dff2);

        System.out.println("Comparing double");
        System.out.println(d == dff);
        System.out.println(d == dff2);

        System.out.println("Comparing double from float");
        System.out.println(dff == dff2);

        System.out.println("These are equal with each other");
        System.out.println(f == ffd);
        System.out.println(f == dff);
        System.out.println(f == dff2);
        System.out.println(ffd == dff);
        System.out.println(ffd == dff2);
        System.out.println(dff == dff2);

        System.out.println("These are equal with each other");
        System.out.println("These are not equal");
        System.out.println(f == d);
        System.out.println(ffd == d);
        System.out.println(d == dff);
        System.out.println(d == dff2);

    }
}
