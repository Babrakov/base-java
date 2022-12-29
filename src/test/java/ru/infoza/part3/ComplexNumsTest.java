package ru.infoza.part3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexNumsTest {

    ComplexNumber a = new ComplexNumber(1, 1);
    ComplexNumber b = new ComplexNumber(1, 1);

    @Test
    public void hashCodeTest() {
        Assertions.assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void equalsTest() {
        Assertions.assertTrue(a.equals(b));
    }
}
