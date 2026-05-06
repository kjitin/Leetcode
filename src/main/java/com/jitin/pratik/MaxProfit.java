package com.jitin.pratik;

public class MaxProfit {


    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 6, 4, 3 };
        //find the best time to buy and sell the stock to make profit
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minSoFar= prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minSoFar;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            minSoFar = Math.min(prices[i], minSoFar);
        }
        return maxProfit;
    }
}
