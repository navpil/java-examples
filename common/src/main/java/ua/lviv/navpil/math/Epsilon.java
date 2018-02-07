package ua.lviv.navpil.math;

/**
 * Checks for how small/big difference between doubles can be.
 *
 * First it checks how small should be the number to make no difference by adding it to 1
 *
 * Secondly it takes (vice versa) how big should be the number, so adding one makes no difference for it
 */
public class Epsilon {

    public static void main(String[] args) {
        double eps = 1;
        do {
            eps = eps * 0.5;
            System.out.println(eps);
        } while (eps + 1 > 1);

        for (int i = 1; i < 308; i++) {
            double d = Double.valueOf("1e" + i);
            if (d+1 == d) {
                System.out.println(d);
                System.out.println(i);
                break;
            }
        }

        //Size of nuclues = 1.6e-15 m
        //Size of universe = 8×10^26 m
        //Difference is factor of 41, there are ~15 significant decimal digits in double.
        //Deleting the size of the atom from the size of the universe is not possible with using doubles
        //However deleting one meter from one light year is still possible
        //Or deleting one atom radius from one meter is also possible




    }
}
