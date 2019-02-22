package com.violence.solveBalancedParentheses;

/**
 * created by user violence
 * created on 22.02.2019
 * class created for project solveBalancedParentheses
 */

public class Main {
    public static void main(String[] args) {
        SolveBalancedParentheses solveBalancedParentheses = new SolveBalancedParentheses();
        boolean result = solveBalancedParentheses.setParenthesesAndExecute("({)}");
        System.out.println("This string balance is ----> " + result);
    }
}
