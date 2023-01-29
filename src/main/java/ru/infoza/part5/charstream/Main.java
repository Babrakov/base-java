package ru.infoza.part5.charstream;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double sum = 0.;
        while (scanner.hasNext()) {
            try {
                sum +=scanner.nextDouble();
            } catch (InputMismatchException e){
                scanner.next();
            }
        }
        System.out.printf("%.6f", sum);
        
    }

}