package com.jitin.leetcode;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path="/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));
    }

    private static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String directory: components) {
            if (directory.equals(".") || directory.isEmpty()) {
            } else if (directory.equals("..")) {
                stack.pop();
            } else {
                stack.push(directory);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String dir: stack) {
            stringBuilder.append("/");
            stringBuilder.append(dir);
        }
        return stringBuilder.length()> 0 ? stringBuilder.toString(): "/";
    }
}
