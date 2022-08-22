package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int number = max;

        while(number != 0) {
            if (number > max) {
                max = number;
            }
            number = input.nextInt();
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
