package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] matrixResult = new int[matrix1.length][matrix2[0].length];
        int value = 0;
        for (int i = 0; i < matrix1.length; i++) {
            for (int z = 0; z < matrix2[0].length; z++) {
                value = 0;
                for (int j = 0; j < matrix1[0].length; j++) {
                    value += matrix1[i][j] * matrix2[j][z];
                }
                matrixResult[i][z] = value;
            }
        }

        return matrixResult;
    }


    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
