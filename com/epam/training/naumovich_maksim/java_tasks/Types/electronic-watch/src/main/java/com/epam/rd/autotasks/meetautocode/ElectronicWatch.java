package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hoursWatch = (seconds % 86400) / 3600;
        int minutesWatch = (seconds % 3600) / 60;
        int secondsWatch = seconds % 60;
        int minutesWatchFirstDigit = minutesWatch / 10;
        int minutesWatchLastDigit = minutesWatch % 10;
        int secondsWatchFirstDigit = secondsWatch / 10;
        int secondsWatchLastDigit = secondsWatch % 10;
        System.out.println(
                hoursWatch +
                        ":" +
                        minutesWatchFirstDigit + minutesWatchLastDigit +
                        ":" +
                        secondsWatchFirstDigit + secondsWatchLastDigit);


    }
}
