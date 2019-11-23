package com.dx.leetcode;

public class lee122 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int temp = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[i - 1]) {
                if (prices[i - 1] > temp) {
                    sum += prices[i - 1] - temp;
                    temp = prices[i];
                }
            } else if (i == prices.length - 1) {
                sum += prices[i] - temp;
            }
            if (prices[i] < temp) {
                temp = prices[i];
                continue;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int i = maxProfit(new int[]{2,4,1});
        System.out.println(i);


    }
}
