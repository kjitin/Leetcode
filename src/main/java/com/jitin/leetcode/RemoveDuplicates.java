package com.jitin.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return  stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
