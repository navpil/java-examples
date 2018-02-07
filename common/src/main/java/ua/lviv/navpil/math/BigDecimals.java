package ua.lviv.navpil.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimals {

    public static void main(String[] args) {
        BigDecimal hundred = new BigDecimal("100");
        System.out.println(hundred.divide(new BigDecimal(3), 10, BigDecimal.ROUND_HALF_EVEN));

        System.out.println(hundred);


        System.out.println(new BigInteger("100").mod(new BigInteger("17")));

    }
}
