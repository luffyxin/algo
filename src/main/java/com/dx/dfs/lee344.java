package com.dx.dfs;

public class lee344 {
    public static void reverseString(char[] s) {
        if(s==null || s.length == 0){
            return;
        }
        for (int i = 0; i < s.length/2; i++) {
            s[i] = (char)(s[i] + s[s.length-i-1]);
            s[s.length-i-1] = (char)(s[i] - s[s.length-i-1]);
            s[i] = (char)(s[i] - s[s.length-i-1]);
        }
        System.out.println(s);
    }

}
