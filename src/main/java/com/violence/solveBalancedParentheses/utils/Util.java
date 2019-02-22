package com.violence.solveBalancedParentheses.utils;

/**
 * created by user violence
 * created on 22.02.2019
 * class created for project solveBalancedParentheses
 */

public class Util {

    private Util(){}

    public static boolean itIsPairString(String line) {
        boolean result = false;
        if ((line.length() % 2) == 0) {
            result = true;
        }
        return result;
    }

    public static String getFirstHalfLine(String line) {
        return line.substring(0, line.length()/2);
    }

    public static String getSecondHalfLine(String line) {
        return line.substring(line.length()/2, line.length());
    }

    public static String revers(String line) {
        StringBuilder builder = new StringBuilder();
        for (int i = line.length()-1; i > 0; i--) {
            builder.append(line.charAt(i));
        }
        return builder.toString();
    }
}
