package com.violence.solveBalancedParentheses;

import com.violence.solveBalancedParentheses.utils.Util;

import java.util.*;

/**
 * created by user violence
 * created on 22.02.2019
 * class created for project solveBalancedParentheses
 */

class SolveBalancedParentheses {
    private String parentheses;
//    private Map<Integer, List<Character>> embedding = new LinkedHashMap<>();
    private List<List<Parentheses>> embedding = new LinkedList<>();

    public boolean setParenthesesAndExecute(String parentheses) {
        this.parentheses = parentheses;
        return execute();
    }

    private boolean execute() {
        boolean result = false;
        if (Util.itIsPairString(this.parentheses)) {
            int levelEmbedding = 0;
            for (int i = 0; i < parentheses.length(); i++) {
                if (isOpenParentheses(parentheses.charAt(i))) {
                    List<Parentheses> parenthesesList = null;
                    try {
                        parenthesesList = embedding.get(levelEmbedding);
                    } catch (IndexOutOfBoundsException e) {
                        parenthesesList = new LinkedList<>();
                        embedding.add(parenthesesList);
                    }
                    Parentheses symbol = new Parentheses();
                    symbol.setSymbol(parentheses.charAt(i));
                    symbol.setEmbedding(levelEmbedding);
                    parenthesesList.add(symbol);
                    levelEmbedding++;
                }
                else if (isClosedParentheses(parentheses.charAt(i))) {
                    --levelEmbedding;
                    List<Parentheses> parenthesesList = embedding.get(levelEmbedding);
                    Parentheses symbol = new Parentheses();
                    symbol.setSymbol(parentheses.charAt(i));
                    symbol.setEmbedding(levelEmbedding);
                    parenthesesList.add(symbol);
                }
            }
            for (List<Parentheses> parenthesesList : embedding) {
                result = checkBalance(parenthesesList);
                if (!result) {
                    return result;
                }
            }
        }
        return result;
    }

    private boolean isOpenParentheses(char point) {
        boolean result = false;
        if (point == '[' || point == '{' || point == '(')
            result = true;
        return result;
    }

    private boolean isClosedParentheses(char point) {
        boolean result = false;
        if (point == ']' || point == '}' || point == ')')
            result = true;
        return result;
    }

    private boolean checkBalance(List<Parentheses> parenthesesList) {
        boolean result = false;
        for (int i = 0; i < parenthesesList.size()-1; i++) {
            result = isOpenParentheses(parenthesesList.get(i).getSymbol()) && isClosedParentheses(parenthesesList.get(parenthesesList.size()-1-i).getSymbol());
            if (!result) {
                return result;
            }
        }
        return result;
    }
}
