package com.jitin.codinginterview;

import java.util.ArrayList;
import java.util.List;

public class Dfs2dArray {

    private static  final int[][] DIRECTiONS = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    public static void main(String[] args) {
        int[][] matrix = {
                           {1,2,3,4,5},
                           {6,7,8,9,10},
                           {11,12,13,14,15},
                           {16,17,18,19,20}
                          };
        System.out.println(traversalDFS(matrix));
    }

    private static List<Integer> traversalDFS(int[][] matrix) {
       boolean[][] seen = new boolean[matrix.length][matrix[0].length];
       List<Integer> values = new ArrayList<>();

       dfs(matrix, 0, 0, seen, values);
       return values;
    }

    private static void dfs(int[][] matrix, int row, int col, boolean[][] seen, List<Integer> values) {
        if (row <0 || col < 0 || row >= matrix.length || col >= matrix[0].length || seen[row][col]) {
            return;
        }

        seen[row][col] = true;
        values.add(matrix[row][col]);
        for (int[] dir : DIRECTiONS) {
            dfs(matrix, row+dir[0], col + dir[1], seen, values);
        }
    }
}
