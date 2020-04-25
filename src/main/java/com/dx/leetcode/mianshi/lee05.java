package com.dx.leetcode.mianshi;

public class lee05 {
    public static String replaceSpace(String s) {
       return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("we are he"));
    }

}
