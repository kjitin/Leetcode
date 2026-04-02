package com.jitin.finalround;

import java.util.*;

public class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {

        // Step 1: Append sentinel 0 to flush remaining bars at the end
        int[] h = Arrays.copyOf(heights, heights.length + 1); // e.g. [2,1,5,6,2,3,0]
        h[h.length - 1] = 0;

        Deque<Integer> stack = new ArrayDeque<>(); // stores indices
        int maxArea = 0;

        // Step 2: Iterate through every bar (including the sentinel)
        // [2 , 1, 5, 6, 2, 3, 0]
        // [0 , 1, 2, 3, 4, 5, 6]
        for (int i = 0; i < h.length; i++) {

            // Step 3 & 4: Pop taller bars and calculate their max area
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {

                int heightIndex = stack.pop();         // index of the bar being evaluated
                int height = h[heightIndex];           // height of that bar

                // Width stretches from the new stack top (+1) to i (-1)
                // If stack is empty, the bar could extend all the way to index 0
                // width = right -left +1 // (i-1) -(stack.peek+1) +1 //i - stack.peek() - 1;
                int width = stack.isEmpty() ? i : (i-1) - (stack.peek()+1) + 1;

                int area = height * width;
                System.out.println("area calculated"+ area);
                maxArea = Math.max(maxArea, area);
            }

            // Step 5: Push current index onto the stack
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        //System.out.println(largestRectangleArea(new int[]{5, 3}));              // 3
    }
}
