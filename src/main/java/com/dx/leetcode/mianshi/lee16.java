package com.dx.leetcode.mianshi;

import java.io.PipedWriter;

public class lee16 {
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            x = 1.0 / x;
            N = -N;
        }
        double rest = 1.0;
        while (N > 0) {
            if (N % 2 != 0) {
                rest *= x;
            }
            x *= x;
            N /= 2;
        }
        return rest;
    }

    public static void main(String[] args) {
        lee16 l = new lee16();
        System.out.println(l.myPow(2.1, 3));
    }
}
