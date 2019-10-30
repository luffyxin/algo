package com.dx;

import java.util.ArrayList;
import java.util.List;

public class leecode784 {

    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");
        for (String s : list) {
            System.out.println(s);
        }
    }


    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        char[] chars = S.toCharArray();
        boolean tran[] = new boolean[chars.length];
        backLowBig(list, chars, tran, 0);
        return list;
    }

    public static void backLowBig(List<String> list, char[] chars, boolean tran[], int start) {
        list.add(String.valueOf(chars));
        for (int i = start; i < chars.length; i++) {
            if (tran[i]) continue;
            if (chars[i] >= 49 && chars[i] <= 57) continue;
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
            tran[i] = true;

            backLowBig(list, chars, tran, i + 1);

            tran[i] = false;

        }

    }
}
