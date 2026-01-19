package com.jitin.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockPairCounter {


    public int countPairs(List<Integer> socks) {
        Map<Integer, Integer> sockCounter = new HashMap<>();

        socks.forEach(s -> sockCounter.merge(s, 1, Integer::sum));
         return sockCounter.values().stream().mapToInt(sockCount -> sockCount/2).sum();
    }
}
