package com.jitin.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockPairCounter {


    public int countPairs(List<Integer> socks) {
        Map<Integer, Integer> sockCounter = new HashMap<>();

        for (Integer sock: socks) {
            sockCounter.put(sock, sockCounter.getOrDefault(sock, 0)+1);
        }
         int pairs = 0;
        for (Integer count: sockCounter.values()) {
            pairs += count/2;
        }
        return pairs;
    }
}
