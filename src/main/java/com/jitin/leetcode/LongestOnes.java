package com.jitin.leetcode;

public class LongestOnes {

    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    private static int longestOnes(int[] nums, int k) {
        int left =0,right;

        for (right =0; right < nums.length; right++) {
            if (nums[right] == 0)
                k--;

            if(k <0) {
                k += 1 - nums[left];
                left++;
            }
        }
        return right -left;
    }

}
