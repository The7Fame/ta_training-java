package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (true){
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
            count++;
        }
        int average = sum / count;
        System.out.println(average);
        }
    }
