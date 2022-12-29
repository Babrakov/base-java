package ru.infoza.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.infoza.part2.MergeArrays.mergeArrays;

public class MergeArraysTest {

    @Test
    public void mergeArraysTest(){
        int[] a = {0, 2, 2};
        int[] b = {1, 3};
        int[] c = {0, 1, 2, 2, 3};
        Assertions.assertArrayEquals(mergeArrays(a,b),c);
    }

}
