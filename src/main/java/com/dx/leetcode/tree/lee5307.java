package com.dx.leetcode.tree;

public class lee5307 {


    public int[] getNoZeroIntegers(int n) {
        int res[] = new int[2];
        for (int i = 1; i < n; i++) {

            boolean itrue = !String.valueOf(i).contains("0");
            boolean jtrue = !String.valueOf(n - i).contains("0");

            if (itrue && jtrue) {
                res[0] = i;
                res[1] = n - i;
                break;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        int i = String.valueOf(192345).indexOf("0");
        System.out.println(String.valueOf(192345).indexOf("0"));

    }


}
