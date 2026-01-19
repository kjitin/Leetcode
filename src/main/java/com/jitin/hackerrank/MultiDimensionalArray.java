package com.jitin.hackerrank;

import java.util.List;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        int[][] arr = {{3,5,6}, {1,2,3}};                                             // |3 5 6 |
        System.out.println(traverseRowMajor(arr));                                    // |1 2 3 |
        System.out.println(traverseColMajor(arr));
    }

    private static boolean traverseRowMajor(int[][] arr) {

        for (int i = 0; i < arr.length; i++) { // rows
            for (int j = 0; j < arr[i].length; j++) { // columns
                System.out.println(arr[i][j]);  // row 0, col 0 row 0 col 1 row 0 col 2  | row 1 col 0 , row 1 col 1 row 1 col 2
            }
        }
        return false;
    }

    private static boolean traverseColMajor(int[][] arr) {

        for (int i = 0; i < arr[0].length; i++) { // rows
            for (int j = 0; j < arr.length; j++) { // columns
                System.out.println(arr[j][i]);
            }
        }
        return false;
    }
}
