package ru.infoza.part6.streamapi;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        System.out.println(mid(13));
        pseudoRandomStream(13)
                .limit(10)
                .mapToObj(x -> " " + x)
                .forEach(System.out::println);
    }



    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed,x-> mid(x));
    }

    public static Integer mid(int x) {
        int square = x*x;
        return (square/10)%10 + (square/100)%10*10 + (square/1000)%10*100;
    }
}
