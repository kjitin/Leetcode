package com.jitin.leetcode;

public class MoveZeroes {
    public int[] moveZeroes(int[] input) {

         int nextNonZero = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i]!=0) {
                int temp = input[nextNonZero];
                input[nextNonZero] = input[i];
                input[i] = temp;
                nextNonZero++;
            }
        }
        return input;

    }
}
