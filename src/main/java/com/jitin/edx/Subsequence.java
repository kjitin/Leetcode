package com.jitin.edx;

public class Subsequence {

    public static void main(String[] args) {
        String input = "c";
        System.out.println(subsequence(input));
    }

    private static String subsequence(String input) {
        if (input.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = input.charAt(0);
            String restOfWord = input.substring(1);

            String subsequencesOfRest = subsequence(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1)) {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }
}
