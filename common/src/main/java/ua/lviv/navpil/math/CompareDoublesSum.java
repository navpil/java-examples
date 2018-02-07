package ua.lviv.navpil.math;

/**
 * Divides one by some number, then sums it back to one and checks for equality
 */
public class CompareDoublesSum {

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {
            if (compare(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean compare(int divisor) {

        double fraction = 1.0 / divisor;

        double sum = 0;
        for (int i = 0; i < divisor; i++) {
            sum += fraction;
        }

        return sum == 1.0;

    }

}
