package com.dx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lee412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if(n==0){
            return list;
        }

        for (int i = 0; i < n; i++) {
            StringBuffer buffer = new StringBuffer();
            boolean is3 = (i + 1) % 3 == 0;
            boolean is5 = (i + 1) % 5 == 0;

            if (is3) {
                buffer.append("Fizz");
            }
            if (is5) {
                buffer.append("Buzz");
            }

            if (!is3 && !is5) {
                buffer.append((i + 1));
            }

            list.add(buffer.toString());
        }
        return list;
    }
}
