package ru.infoza.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static ru.infoza.part2.Factorial.factorial;

public class FactorialTest {

    @Test
    public void checkFactorialOne() {
        Assertions.assertEquals(factorial(1), BigInteger.ONE);
    }

    @Test
    public void checkFactorialTree() {
        Assertions.assertEquals(factorial(3), BigInteger.valueOf(6));
    }

}
