package ua.lviv.navpil.math;

public class TrianglesKahan {

    public static void main(String[] args) {
        System.out.println(area(99999.99996,  0.00003, 99999.99994));
        System.out.println(area(10000, 5000.000001, 15000));
    }

    private static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s -c ));
    }

}
