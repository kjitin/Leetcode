package com.jitin.finalround;

public class MinBlockConsecutive {

    public static void main(String[] args) {
        System.out.println(minAdditions(new int[]{1,4,3,2})); //4 [5,4,3,2]
        System.out.println(minAdditions(new int[]{2,3,2,3})); //4 [2,3,4,5]
        System.out.println(minAdditions(new int[]{5,7,9,4,11})); //4 [2,3,4,5]
    }

    private static int minAdditions(int[] arr) {
        return Math.min(minCostIncreasing(arr), minCostDecreasing(arr));
    }

    //Try to make arr into [a, a-1, a-2]
    private static int minCostDecreasing(int[] arr) {
        int a= Integer.MIN_VALUE;

        // Target at index i : a -i
        // We can only ADD, so  a -i >= arr[i] ->  a >= arr[i] +i
        for (int i = 0; i < arr.length; i++) {
            a = Math.max(a, arr[i] + i);
        }

        int cost = 0;
        for (int i = 0; i < arr.length; i++) {
            cost += (a -i) - arr[i];
        }
        return cost;
    }

    //Try to make arr into [a, a+1, a+2 ...]
    private static int minCostIncreasing(int[] arr) {
        // Target at index i is : a+i
        // We can only ADD, so : a+i >= arr[i] -> a >= arr[i] - i
        //Pick the smallest valid a: a = max(arr[i] -i)

        int a = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            a = Math.max(a, arr[i] - i);
        }

        int cost =0;
        for (int i = 0; i < arr.length; i++) {
            cost += (a+i) - arr[i];
        }
        return cost;
    }
}
