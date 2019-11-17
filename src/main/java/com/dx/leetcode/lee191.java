package com.dx.leetcode;

public class lee191 {

    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);

        int cout =0;
        for (char c : s.toCharArray()) {
            if(c== '1'){
                cout++;
            }
        }
        return cout;
    }

}
