package com.dx.leetcode;

/**
 * 求众数
 */
public class lee169 {

    public static int majorityElement(int[] nums) {
        int count = 1;

        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == temp) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    temp = nums[i];
                    count++;
                }
            }

        }
        return temp;
    }

    public static void main(String[] args) {

        int i = majorityElement(new int[]{2, 2, 2, 1, 1, 1, 1, 2, 2});
        System.out.println(i);


    }


}
