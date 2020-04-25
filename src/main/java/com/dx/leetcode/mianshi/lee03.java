package com.dx.leetcode.mianshi;

import com.google.common.collect.Lists;

import java.util.HashMap;

public class lee03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if(hashMap.containsKey(num)){
                return num;
            }
            hashMap.put(num,0);
        }
        return 0;
    }

}
