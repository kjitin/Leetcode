package com.jitin.leetcode;

public class FindBestSubArray {

    public static void main(String[] args) {
        int[] nums = {3,-1,4,12,-8,5,6};
        int k=4;
        System.out.println(findBestSubArray(nums, k));
    }

    private static int findBestSubArray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;

        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i-k];
            ans = Math.max(ans, curr);
        }
        return ans;
    }

}
