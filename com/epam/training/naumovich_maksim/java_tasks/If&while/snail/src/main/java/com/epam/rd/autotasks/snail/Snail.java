package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    int b = input.nextInt();
    int h = input.nextInt();
    int days = 0;
    int sum = 0;
    if ((a == b && a < h) || (a < b && a < h)) {
        System.out.println("Impossible");
        } else {
            while (sum < h) {
                sum += a;
                days++;
                if (sum >= h) {
                    break;
                } else {
                    sum -= b;
                }
            }
            System.out.println(days);
        }
    }
}
