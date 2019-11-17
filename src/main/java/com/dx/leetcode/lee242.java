package com.dx.leetcode;

import java.util.Arrays;

public class lee242 {

    public boolean isAnagram(String s, String t) {

        char[] sList = s.toCharArray();
        char[] tList = t.toCharArray();

        Arrays.sort(sList);
        Arrays.sort(tList);
        return Arrays.equals(sList,tList);

    }

}
