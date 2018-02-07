package ua.lviv.navpil.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Shows that in some instances BigDecimal gives precision loss over double
 */
public class PrecisionLoss {

    public static void main(String[] args) {
        BigDecimal ten = new BigDecimal("10.0", MathContext.UNLIMITED);
        BigDecimal three = new BigDecimal("3.0", MathContext.UNLIMITED);

        System.out.println(ten.divide(three, new MathContext(17, RoundingMode.HALF_EVEN)).multiply(three));
        System.out.println(10.0 / 3.0 * 3.0);


    }
}
