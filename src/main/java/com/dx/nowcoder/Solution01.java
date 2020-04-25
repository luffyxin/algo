package com.dx.nowcoder;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 */
public class Solution01 {

    public static void main(String[] args) {
        Solution01 s = new Solution01();
        System.out.println(s.solution(1024));

    }

    public int solution(int n) {
        if (n < 10) {
            return 10 + n;
        }
        int res = 0;
        int temp = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * temp;
                temp *= 10;
                n /= i;
            }
        }
        if (n > 1) {
            return -1;
        }
        return res;
    }


}
