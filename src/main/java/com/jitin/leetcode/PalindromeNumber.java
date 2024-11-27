package com.jitin.leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        int input = 121;
        System.out.println(palindromeNumber(121));
    }

    private static boolean palindromeNumber(int input) {
        int remainder = 0;
        int sum =0;
        int temp = input;

        while (input>0) {
            remainder = input%10;
            sum = (sum*10) + remainder;
            input = input/10;
        }
        if (temp == sum)
            return true;
        else
            return false;
    }
}
