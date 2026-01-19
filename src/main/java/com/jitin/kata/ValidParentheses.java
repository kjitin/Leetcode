package com.jitin.kata;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{()}"));
    }

    public static boolean isValid(String braces) {
        // Add code here
        if (braces == null || braces.isEmpty())
            return false;

        Stack<Character> stack = new Stack<>();

        for (Character ch : braces.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '[')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }


}
