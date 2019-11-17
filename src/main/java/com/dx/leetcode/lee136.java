package com.dx.leetcode;

public class lee136 {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int a = nums[0];

        for (int i = 1; i < nums.length; i++) {
             a = a^nums[i];
        }
        return a;
    }
}
