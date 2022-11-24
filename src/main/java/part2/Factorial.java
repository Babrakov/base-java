package main.java.part2;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(int value) {
        if (value==0) return BigInteger.valueOf(1);
        return ((value > 1) ? factorial(value - 1).multiply(BigInteger.valueOf(value)) : BigInteger.valueOf(1));
    }

}
