package com.dx.leetcode;

import com.dx.dfs.TreeNode;

public class lee108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return arrayToBST(nums,0,nums.length-1);
    }

    private TreeNode arrayToBST(int[] nums, int l, int r) {
        if(l > r){
            return null;
        }
        int mid = l + (r - l) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums,l,mid-1);
        root.right = arrayToBST(nums,mid+1,r);
        return root;
    }
}
