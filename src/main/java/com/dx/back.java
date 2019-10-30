package com.dx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class back {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3};
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        combineSum(8, nums, new ArrayList<>(),0);
    }

    // 没有重复值全排列
    public static void callBack(int[] nums, List<Integer> templeList) {
        if (templeList.size() == nums.length) {
            System.out.println(templeList.toString());
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (templeList.contains(nums[i])) continue;
                templeList.add(nums[i]);
                callBack(nums, templeList);
                templeList.remove(templeList.size() - 1);
            }

        }

    }

    // 有重复值全排列
    public static void helper(int[] nums, List<Integer> templeList, boolean[] used) {
        if (templeList.size() == nums.length) {
            System.out.println(templeList.toString());
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                templeList.add(nums[i]);
                used[i] = true;
                helper(nums, templeList, used);
                templeList.remove(templeList.size() - 1);
                used[i] = false;
            }
        }
    }

    // 子集
    public static void child(int[] nums, List<Integer> templeList, int start) {
        System.out.println(templeList.toString());
        for (int i = start; i < nums.length; i++) {
            templeList.add(nums[i]);
            child(nums, templeList, i + 1);
            templeList.remove(templeList.size() - 1);
        }

    }

    // 组合
    public static void combine(int len, int size, List<Integer> templement, int start) {
        if (templement.size() == size) {
            System.out.println(templement.toString());
        } else {
            for (int i = start; i < len + 1; i++) {
                if (templement.contains(i)) continue;
                templement.add(i);
                combine(len, size, templement, i + 1);
                templement.remove(templement.size() - 1);
            }
        }

    }

    //给定一个无重复元素的数组** candidates** 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    public static void combineSum(int target, int[] candidates, List<Integer> templement,int start) {
        if (getSum(templement).equals(target)) {
            System.out.println(templement.toString());
        } else {
            for (int i = start; i < candidates.length && getSum(templement) <= target; i++) {

                templement.add(candidates[i]);
                combineSum(target, candidates, templement,i);
                templement.remove(templement.size() - 1);
            }
        }
    }

    public static Integer getSum(List<Integer> templement) {
        int sum = 0;
        for (Integer integer : templement) {
            sum += integer;
        }
        return sum;
    }
}
