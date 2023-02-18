package ru.infoza.part6.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int next;
        while (scanner.hasNext()) {
            try {
                next = scanner.nextInt();
                if (i%2!=0)
                    list.add(next);
                i++;
            } catch (InputMismatchException e){
                scanner.next();
            }
        }
        Collections.reverse(list);
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
    }


}
