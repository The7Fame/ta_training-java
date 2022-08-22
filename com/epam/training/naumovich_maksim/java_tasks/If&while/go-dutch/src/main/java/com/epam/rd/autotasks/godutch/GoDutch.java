package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        int numberOfFriends = input.nextInt();
        if (sum < 0){
            System.out.println("Bill total amount cannot be negative");
        }else if(numberOfFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
        }else{
            double sumWithTips = 1.1 * sum;
            int sumEachPersonPay = (int)(Math.floor(sumWithTips / numberOfFriends));
            System.out.println(sumEachPersonPay);
        }
    }
}
