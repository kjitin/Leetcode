package com.jitin.hackerrank;

import java.util.List;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] array = new long[n + 2]; // +2 to handle b+1 without overflow

        for (List<Integer> q : queries) {
            int a = q.get(0);
            int b = q.get(1);
            int k = q.get(2);


            array[a] += k;
            array[b + 1] -= k;
        }

        long max = 0;
        long current = 0;

        for (int i = 1; i <= n; i++) {
            current += array[i];
            if (current > max) {
                max = current;
            }
        }

        return max;
    }

    public static long arrayManipulationBrute(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1]; // 1-based indexing

        for (List<Integer> q : queries) {
            int a = q.get(0);
            int b = q.get(1);
            int k = q.get(2);

            // Naively add k from index a to b
            for (int i = a; i <= b; i++) {
                arr[i] += k;
            }
        }

        // Find max value
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = List.of(
                List.of(1, 5, 3),
                List.of(4, 8, 7),
                List.of(6, 9, 1)
        );

        int n = 10;
        System.out.println(arrayManipulation(n, queries)); // Output: 200
        System.out.println(arrayManipulationBrute(n, queries)); // Output: 200
    }
}

