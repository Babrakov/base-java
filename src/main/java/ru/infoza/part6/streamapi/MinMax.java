package ru.infoza.part6.streamapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
// комментим след строчку для теста стрима без элементов
        Collections.addAll(list, 3, 6, 8, 9, 13, 16, 18, 19);
        findMinMax(list.stream(), (o1, o2) -> {
            if (o1.intValue() > o2.intValue()) {
                return 1;
            }
            if (o1.intValue() < o2.intValue()) {
                return -1;
            }
            return 0;
        }, (v1, v2) -> System.out.println(v2 - v1));  // 19 - 3 = 16

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0),list.get(list.size()-1));
        }
    }
}
