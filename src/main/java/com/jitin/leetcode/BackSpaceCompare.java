package com.jitin.leetcode;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class BackSpaceCompare {

    public static void main(String[] args) {
        String first = "ab#c";
        String second = "tt#c";
        System.out.println(backSpaceCompare(first).equals(backSpaceCompare(second)));
    }

    private static String backSpaceCompare(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack.stream().map(Objects::toString).collect(Collectors.joining(""));
    }
}
