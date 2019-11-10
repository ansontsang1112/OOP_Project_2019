package com.anson.main.Utils;

public class StringUtils {
    public static String csvFormatter(String[] stringArr) {
        String returnString = "";
        for(int i = 0; i < stringArr.length; i++) {
            if(i == 0) {
                returnString = stringArr[i];
            } else {
                returnString += (","+stringArr[i]);
            }
        }
        return returnString;
    }
}
