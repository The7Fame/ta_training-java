package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberPeople = input.nextInt();
        int numberPieces = input.nextInt();
        int finalNumberPizza = 0;
        int finalNumberPieces = 0;
        do{
            finalNumberPieces +=numberPieces;
            finalNumberPizza++;
        }while(finalNumberPieces % numberPeople !=0);
        System.out.println(finalNumberPizza);
    }
}
