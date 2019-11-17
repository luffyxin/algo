package com.dx.leetcode;

public class lee171 {

    public static int titleToNumber(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if(s.length()==1){
            return s.toCharArray()[0]-64;
        }
        char[] chars = s.toCharArray();
        int sum = chars[s.length()-1]-64;
        int time = 1;
        for (int i = chars.length - 2; i >= 0; i--) {
            int temp = chars[i] - 64;
            sum = sum + (int)Math.pow(26,time) * temp ;
            time++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }
}
