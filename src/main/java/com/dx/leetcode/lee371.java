package com.dx.leetcode;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class lee371 {

    public static void main(String[] args) {
        System.out.println(getSum(4,5));
    }

    public static int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }

}
