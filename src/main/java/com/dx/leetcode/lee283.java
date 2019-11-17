package com.dx.leetcode;

public class lee283 {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 1, 2});
    }
}
