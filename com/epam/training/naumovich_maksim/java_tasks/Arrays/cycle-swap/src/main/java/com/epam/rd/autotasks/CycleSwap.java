package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
    int[] temp = Arrays.copyOf(array, array.length - 1);
    array[0] = array[array.length - 1];
    System.arraycopy(temp, 0, array, 1, temp.length);
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length == 0 || array.length == 1 || shift % array.length == 0) {
            return;
        }
        int[] tempEnd = Arrays.copyOf(array, array.length - shift);
        int[] tempStart = Arrays.copyOfRange(array, array.length - shift, array.length);
        System.arraycopy(tempStart, 0, array, 0, tempStart.length);
        System.arraycopy(tempEnd, 0, array, tempStart.length, tempEnd.length);
    }
}
