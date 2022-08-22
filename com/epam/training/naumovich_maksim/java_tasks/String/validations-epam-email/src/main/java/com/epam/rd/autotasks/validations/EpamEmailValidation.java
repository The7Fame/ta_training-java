package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.length() == 0){
            return false;
        }
        String toCompile = "[a-zA-Z]+_[a-zA-Z]+[0-9]?@epam.com";
        Pattern pattern = Pattern.compile(toCompile);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();


    }
}





