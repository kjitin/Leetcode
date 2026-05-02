package com.jitin.pratik;

public class MaxSoFar {

    public static void main(String[] args) {

        // Test cases
        // if arr = [-1] return 0
        // if arr = [5] return 5
        // if arr =[] return 0
        //int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
        int[] arr = { -1 };
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int currentMax = 0;
        int max = 0;

        for (int i=0; i < arr.length; i++) {
            currentMax = currentMax+ arr[i];
            if(currentMax < 0) {
                currentMax =0;
            }
            max = Math.max(max, currentMax);
            //currentMax = Math.max(currentMax+ arr[i], arr[i]);
            //max = Math.max(max, currentMax);
        }
        return max;
    }
}
