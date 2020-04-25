package com.dx.leetcode.mianshi;

public class lee17 {

    public static int[] printNumbers(int n) {
        int x = 9;
        for (int i = 1; i < n; i++) {
            x = x * 10 + 9;
        }
        System.out.println(x);
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        printNumbers(5);


    }
}
