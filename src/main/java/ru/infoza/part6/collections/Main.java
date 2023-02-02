package ru.infoza.part6.collections;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);
//        num1.add(1);
//        num1.add(2);
//        num1.add(3);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);
//        num2.add(0);
//        num2.add(1);
//        num2.add(2);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> first = new HashSet<>();
        first.addAll(set1);
        Set<T> second = new HashSet<>();
        second.addAll(set2);

        Set<T> all = new HashSet<>();
        all.addAll(first);
        all.addAll(second);

        first.retainAll(second);
        all.removeAll(first);

        return all;
    }
}
