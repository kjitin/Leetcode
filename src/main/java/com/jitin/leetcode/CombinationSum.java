package com.jitin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7 };
        int target = 7;
        combinationSum.combinationSum(candidates, target);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arrayList = new ArrayList<Integer>();
        findAnswer(candidates, target, 0, arrayList);

        return result;
    }

    private void findAnswer(int[] candidates, int target, int start, List<Integer> arrayList) {
        if (target <0) {
            return;
        }

        if (start == candidates.length) {
            if (target ==0) {
                result.add(arrayList);
            }
            return;
        }
        arrayList.add(candidates[start]);
        findAnswer(candidates, target - candidates[start], start, arrayList);
        arrayList.remove(arrayList.size() -1);
        findAnswer(candidates, target, start+1, arrayList);
        return;

    }
}
