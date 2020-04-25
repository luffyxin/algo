package com.dx.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class lee5143 {
    public static void main(String[] args) {
        int[] ints = decompressRLElist(new int[]{1, 2, 3, 4});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }


    public static int[] decompressRLElist(int[] nums) {

        List<Integer> resopnList = new ArrayList<>();

        for (int i = 0; i < nums.length-1; i+=2) {
            for(int j=0;j<nums[i];j++){
                resopnList.add(nums[i+1]);
            }
        }

        int [] arr = new int [resopnList.size()];

        for (int i = 0; i < resopnList.size(); i++) {
            arr[i] = resopnList.get(i);
        }

        return arr;

    }
}
