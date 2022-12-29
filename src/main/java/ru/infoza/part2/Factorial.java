package main.java.part2;

import java.math.BigInteger;

public class Factorial {

    /*Реализуйте метод, вычисляющий факториал заданного натурального числа.
      Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long
      очень скоро не хватит. Поэтому будем использовать BigInteger.*/
    public static BigInteger factorial(int value) {
        if (value==0) return BigInteger.valueOf(1);
        return ((value > 1) ? factorial(value - 1).multiply(BigInteger.valueOf(value)) : BigInteger.valueOf(1));
    }

}
