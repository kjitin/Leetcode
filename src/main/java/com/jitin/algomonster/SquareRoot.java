package com.jitin.algomonster;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = squareRoot(n);
        System.out.println(res);
    }

    private static int squareRoot(int n) {
        if (n ==0)
            return 0;

        int left = 1;
        int right = n;
        int result = -1;
        while (left <= right) {
            int mid = left +(right -left)/2;
            if (mid == n/mid) {
                return mid;
            } else if (mid > n/mid) {
                result = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return result -1;
    }
}
