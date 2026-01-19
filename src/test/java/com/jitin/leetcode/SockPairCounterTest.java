package com.jitin.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 You are given a list of integers where each integer represents the colour of
 a sock in a pile. A pair is formed when two socks have the same colour.
 Your task is to count the total number of pairs that can be formed from the
 given pile.
 **/
public class SockPairCounterTest {

    private SockPairCounter solution;

    @Before
    public void setUp() {
        solution = new SockPairCounter();
    }

    @Test
    public void testCountPairsWithSimpleInput() {
        var socks = List.of(1,1,2,2,2,3);

        assertEquals(2, solution.countPairs(socks));
    }

    @Test
    public void testCountPairsWithDifferentInput() {
        var socks = List.of(1,1,2,2,2,2,3);

        assertEquals(3, solution.countPairs(socks));
    }

    @Test
    public void testCountWithEmpty() {
        assertEquals(0, solution.countPairs(List.of()));
    }

    @Test
    public void testCountWith0Pairs() {
        assertEquals(0, solution.countPairs(List.of(1,2,3)));
    }
}
