package com.dx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lee118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yang = new ArrayList<>();
        if(numRows == 0){
            return yang;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        yang.add(first);
        if(numRows == 1){
            return yang;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        yang.add(second);
        if(numRows == 2){
            return yang;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> per = yang.get(i - 1);
            for (int j = 1; j < i ; j++) {
                temp.add(per.get(j - 1) + per.get(j));
            }
            temp.add(1);
            yang.add(temp);
        }
        return yang;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);

        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }
}
