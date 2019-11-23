package com.dx.leetcode;

public class lee121 {

    public static int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }

        int min = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1] && prices[i] < min) {
                min = i;
            }

            if (prices[i] > prices[i - 1] && prices[i] > max) {
                max = i;
            }


        }

        return prices[max] - prices[min];


    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int []{7,1,5,3,6,4}));


    }

}
