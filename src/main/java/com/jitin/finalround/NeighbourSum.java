package com.jitin.finalround;

import java.util.Arrays;

// Given an array a, task is to output
// an array b of the same length by applying the following transformation
// b[i] = a[i-1] + a[i] + a[i+1] , if a[i-1] does not exist use 0
public class NeighbourSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,2,3,4,5})));
    }

    private static int[] solution(int[] a) {

        int n = a.length; //find length of original array
        int[] b = new int[n]; //create new array of same length


        for (int i = 0; i < n; i++) {
            int left = (i>0) ? a[i-1]: 0;
            int current = a[i];
            int right = (i< n -1)? a[i+1]: 0;
            b[i] = left+current+right;
        }
        return b;
    }
}
