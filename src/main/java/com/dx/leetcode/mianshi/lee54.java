package com.dx.leetcode.mianshi;

import com.dx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lee54 {
    public int kthLargest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        midBian(root, list);
        return list.get(k - 1);

    }

    public void midBian(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        midBian(root.right, list);
        list.add(root.val);
        midBian(root.left, list);
    }
}
