package com.jitin.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoveZeroesTest {


    @Test
    public void testStandard() {
        var input = new int []{0,2,4,0,9,0};
        var solution = new MoveZeroes();
        var output = solution.moveZeroes(input);

        var expected = new int[] {2,4,9,0,0,0};
        boolean result =Arrays.equals(expected, output);
        assertTrue(result);
    }
}
