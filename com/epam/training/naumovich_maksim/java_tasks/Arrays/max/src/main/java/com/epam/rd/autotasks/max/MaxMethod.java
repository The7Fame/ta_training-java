package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int maxValue = values[0];
        for (int elem : values) {
            if (elem > maxValue) {
                maxValue = elem;
            }
        }
        return maxValue;
    }
}