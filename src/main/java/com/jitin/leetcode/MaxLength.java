package com.jitin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxLength {

    public static void main(String[] args) {
        int[] nums = {0,1, 1, 0};
        System.out.println(findMaxLength(nums));
        System.out.println(findBruteMaxLength(nums));
    }

    private static int findBruteMaxLength(int[] nums) {
        int maxlen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes =0, ones=0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxlen = Math.max(maxlen, end -start +1);
                }
            }
        }
        return maxlen;
    }

    private static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen =0, count=0;

        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1: -1);
            if (map.containsKey(count)){
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
