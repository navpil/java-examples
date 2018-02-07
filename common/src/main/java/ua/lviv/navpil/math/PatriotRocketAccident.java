package ua.lviv.navpil.math;

/**
 * Patriot used 24 bits, which Java has not
 *
 * http://www-users.math.umn.edu/~arnold/disasters/patriot.html
 *
 */
public class PatriotRocketAccident {


    public static void main(String[] args) {
        double speed = 1676;//m/s;

        int hours = 100;
        int tenthOfSeconds = hours * 60 * 60 * 10;

        double realSeconds = hours * 60 * 60;

        float f = 0;
        for (int i = 0; i < tenthOfSeconds; i++) {
            f += (1.0f / 10f);
        }

        double d = 0;
        for (int i = 0; i < tenthOfSeconds; i++) {
            d += (1 / 10f);
        }

        System.out.println(f);
        System.out.println(tenthOfSeconds / 10);

        System.out.println((realSeconds - f) * speed);

        System.out.println(d);
        System.out.println(tenthOfSeconds / 10);

        System.out.println((realSeconds - d) * speed);



    }
}
