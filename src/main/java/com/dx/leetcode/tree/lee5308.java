package com.dx.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class lee5308 {


    public static int minFlips(int a, int b, int c) {

        String stra = Integer.toBinaryString(a);
        String strb = Integer.toBinaryString(b);

        System.out.println(stra + "    " + strb);
        List<Integer> res = new ArrayList<>();
        List<String> log = new ArrayList<>();

        change(log,stra, strb, c, res, 0);
        int min = res.get(0);
        for (Integer re : res) {
            if (re < min) {
                min = re;
            }
        }
        return min;
    }

    private static String change01(int index, String target) {

        if (target.substring(index, index + 1).equals("1")) {
            target = target.substring(0, index) + "0" + target.substring(index + 1);
        } else if (target.substring(index, index + 1).equals("0")) {
            target = target.substring(0, index) + "1" + target.substring(index + 1);
        }
        return target;
    }


    private static void change(List<String> log,String a, String b, int c, List<Integer> ans, int deep) {

        Integer inta = Integer.valueOf(a, 2);
        Integer intb = Integer.valueOf(b, 2);
        System.out.println("a:"+inta + "  b:" +intb);
        if (inta + intb == c) {
            if(log.contains(a+b)){
                return;
            }
            System.out.println("a: " + a + "b: " + b + "    time: " + deep);
            System.out.println("--------------------------------------------------------------------------");

            log.add(a+b);
            ans.add(deep);
            return;
        }

        for (int i = deep; i < a.length() + b.length(); i++) {
            if (i >= a.length()) {
                int j = i - a.length();
                System.out.print("b:"+b + "->");
                b = change01(j, b);
                deep++;
                System.out.println(b+ "   a:" + a +   "  deep:"+deep);
                change(log,a, b, c, ans, deep);

                b = change01(j, b);
                deep--;

            } else {
                System.out.print("a:"+a + "->   ");
                a = change01(i, a);
                deep++;
                System.out.println(a+ "   b:"+ b +  "  deep:"+deep);
                change(log,a, b, c, ans, deep);

                a = change01(i, a);
                deep--;

            }
        }
    }


    public static void main(String[] args) {
        int i = minFlips(2, 6, 5);
        System.out.println(i);

    }
}
