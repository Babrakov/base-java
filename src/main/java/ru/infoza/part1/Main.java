package ru.infoza.part1;

public class Main {
    public static void main(String[] args) {
//        double a = 0.1;
//        double b = 0.2;
//        double c = 0.3;
//        System.out.println(doubleExpression(a,b,c));
//        System.out.println(getBit(2,1));
//        System.out.println(flipBit(1,1));
//        System.out.println(charExpression(29));
        System.out.println(isPowerOfTwo(4));
    }


    public static boolean doubleExpression(double a, double b, double c) {
        return ( (a + b - c > -0.0001) && (a + b - c < 0.0001) );
    }

    public static int flipBit(int value, int bitIndex) {
        int realBitIndex = bitIndex-1;
        int mask = 1 << realBitIndex;
        int bit = ((value & (1 << realBitIndex)) != 0) ? 0 : 1;
        return (value & ~mask) |
                (( bit << realBitIndex) & mask);
    }

    public final static Boolean getBit(int value, int bitPosition)
    {
        return (value & (1 << bitPosition)) != 0;
    }

//    public final static int setBit(int value,int bitPosition,boolean bitValue)
//    {
//        if (bitValue)
//            return (int) (value | (1 << bitPosition));
//        return (int) (value & ~(1 << bitPosition));
//    }

    public static char charExpression(int a) {
        int slash = (int) '\\';
        int symbol = slash+a;
        return (char) symbol;
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        if (value == 0) return false;
        return (int)(Math.ceil((Math.log(value) / Math.log(2))))
                == (int)(Math.floor(
                ((Math.log(value) / Math.log(2)))));
    }

}