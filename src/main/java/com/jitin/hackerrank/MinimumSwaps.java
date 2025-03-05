package com.jitin.hackerrank;

public class MinimumSwaps {

    public static void main(String[] args) {
        int[] input = {7,1,3,2,4,5,6};

        System.out.println(minimumSwaps(input));
    }

    private static int minimumSwaps(int[] input) {
        int minSwaps =0, index =0, temp;

        while (index < input.length) {
            if (input[index] != index+1) {
                temp = input[index];
                input[index] = input[input[index] -1];
                input[temp -1] = temp;
                minSwaps++;
            } else {
                index++;
            }
        }
        return minSwaps;
    }
}
