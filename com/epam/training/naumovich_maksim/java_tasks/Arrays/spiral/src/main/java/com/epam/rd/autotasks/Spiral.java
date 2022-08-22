package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns){
        int[][] array = new int[rows][columns];

        int iter = rows / 2;
        if (rows % 2 == 1) {
            iter++;
        }

        int c = 1;
        for (int i = 0; i < iter; i++) {
            for (int j = i; j < columns - i; j++) {
                array[i][j] = c;
                c++;
            }
            for (int j = i + 1; j < rows - i; j++) {
                array[j][columns - i - 1] = c;
                c++;
            }
            for (int j = columns - 2 - i; j >= i; j--) {
                if (i == iter - 1 && rows % 2 == 1) {
                    break;
                }
                array[rows - 1 - i][j] = c;
                c++;
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                array[j][i] = c;
                c++;
            }
        }
        return array;
    }
}
