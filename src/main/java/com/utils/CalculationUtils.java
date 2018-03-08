package com.utils;

public class CalculationUtils {

    public static int complicatedFunction(int n) {

        for (int i = 1; i < 10000; i++) {
            n = (n ^ i) % i;
            if (n <= 0) {
                n = 10;
            }
        }

        return n;
    }


}
