package com.jitin.leetcode;

public class RomanToInt {

    public static void main(String[] args) {

        String input = "IV";
        System.out.println(romanToInt(input));
    }

    private static int romanToInt(String input) {
        int sum = 0;
        int prev = 0;
        int[] roman = new int[128];
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        for(int i= 0; i < input.length() ; i++) {
           if (i< input.length() -1 && roman[input.charAt(i)] < roman[input.charAt(i+1)]) {
               sum -= roman[input.charAt(i)];
           } else {
               sum += roman[input.charAt(i)];
           }
            //sum = sum+ roman[input.charAt(input.length() -1)];
        }
        return sum;
    }

}
