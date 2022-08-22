package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {

        if (values == null || values.length == 0){
            return OptionalInt.empty();
        }
        int maxNumber = values[0];
        for (int val: values){
            if (val>maxNumber){
                maxNumber = val;
            }
        }
        return OptionalInt.of(maxNumber);
    }
}
