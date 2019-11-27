package com.dx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lee202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
            if (n == 0) {
                if (temp.contains(sum)) {
                    return false;
                } else {
                    temp.add(sum);
                }
                if (sum == 1) {
                    return true;
                }
                n = sum;
                sum = 0;
            }
        }
        return false;
    }

}
