package com.ua.lab.homework.shape;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.*;

public class Loops {

    public static void main(String[] args) {

        int decimal = 10;

        List<Double> x = new ArrayList<>();

        int N = 350;
        // ======================================
        for (int a = 0; a < decimal; a++) {
            for (int d = 0; d < decimal; d++) {
                int num = N + 1000 * a + d;
                if (prime(num)) {
                    System.out.println(num);
                }
            }
        }

        N = 92000;
        // ======================================

        for (int a = 0; a < decimal; a++) {
            for (int b = 0; b < decimal; b++) {
                for (int c = 0; c < decimal; c++) {
                    double number = N + c + b * pow(decimal, 1) + a * pow(decimal, 2);
                    if (number / 874 % decimal == 0) {
                        x.add(number / 874);
                        System.out.println(number);
                    }
                }
            }
        }
    }

    private static boolean prime(int n) {
        if (n <= 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//        a = power(2, number);
//        b = power(1, number);
//        c = power(0, number);

//    private static double power(int n, double number) {
//        boolean result = x == number / 874.0;
//        number += pow(10, n);
//        System.out.println(x);
//        return number;
