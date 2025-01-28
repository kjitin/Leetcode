package com.jitin.algomonster;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] input = {1,1,2,2,3,4,4};
        System.out.println(singleNonDuplicate(input));
    }

    private static int singleNonDuplicate(int[] input) {
        int left =0;
        int right = input.length -1;
        int ans = 0;

        while (left<= right) {
            int mid = (left+right)/2;
            if(toTheLeft(mid, input)) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return input[ans];
    }

    private static boolean toTheLeft(int mid, int[] input) {
        if (mid == input.length -1) {
            return true;
        } else if (mid %2 ==1) {
            return input[mid] != input[mid -1];
        } else {
            return input[mid] != input[mid+1];
        }

    }
}
