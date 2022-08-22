package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {

       if (color == null || color.length() == 0){
           return false;
       }
       String toCompile = "#[a-fA-F0-9]{6}";
       Pattern pattern = Pattern.compile(toCompile);
       Matcher matcher = pattern.matcher(color);

       if(matcher.matches()) {
            return true;
        }

       toCompile = "#[a-fA-F0-9]{3}";
       pattern = Pattern.compile(toCompile);
       matcher = pattern.matcher(color);
       return matcher.matches();

    }
}





