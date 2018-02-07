package ua.lviv.navpil.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Shows that high precision operations on BigDecimals can be up to 30 times(!) slower than double equivalents

 */
public class Speed {

    public static void main(String[] args) {

        System.out.println(10.0 / 3.0);
        System.out.println(new BigDecimal("10.0", MathContext.UNLIMITED).divide(new BigDecimal("3.0", MathContext.UNLIMITED), new MathContext(17, RoundingMode.HALF_EVEN)));
        System.out.println(measure(() -> {double d = 10.0 / 3.0;}));
        System.out.println(measure(() -> {BigDecimal d = new BigDecimal("10.0", MathContext.UNLIMITED).divide(new BigDecimal("3.0", MathContext.UNLIMITED), new MathContext(17, RoundingMode.HALF_EVEN));}));

    }

    public static long measure(Runnable runnable) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            runnable.run();
        }
        return System.currentTimeMillis() - start;

    }
}
