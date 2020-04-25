package com.dx.leetcode.mianshi;

public class lee58 {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public static void main(String[] args) {

        String abcdefg = reverseLeftWords("lrloseumgh", 6);
        System.out.println(abcdefg);

    }

}
