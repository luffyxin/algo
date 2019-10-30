package com.dx;

import java.util.ArrayList;
import java.util.List;

public class huisu {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // 不必先排序
        backtrack(list, new ArrayList<>(), nums, 1);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int x) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            System.out.println("满足条件：" + tempList.toString());
        } else {
            for (int i = 0; i < nums.length; i++) {
                System.out.println("此时的list:" + tempList.toString());
                System.out.println("遍历到：" + nums[i]);
                if (tempList.contains(nums[i])) {
                    System.out.println("元素已存在，跳过");
                    continue;
                } // 元素已经存在，跳过
                tempList.add(nums[i]);
                System.out.println("添加没有的数字：" + nums[i]);
                System.out.println("递归前的list" + tempList.toString());
                System.out.println("当前递归层数：" + x);
                x++;
                System.out.println("------------------------->进入到第"+x+"层");
                backtrack(list, tempList, nums, x);
                x--;
                System.out.println("回退前的list：" + tempList.toString());
                System.out.println("回退前的i：" + i);
                tempList.remove(tempList.size() - 1);
                System.out.println("<-------------------------回退到"+x+"层");
                System.out.println("回退后的list：" + tempList.toString());
                System.out.println("回退后的i：" + i);
            }
        }
    }
}
