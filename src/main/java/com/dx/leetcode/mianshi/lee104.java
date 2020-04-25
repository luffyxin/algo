package com.dx.leetcode.mianshi;

import com.dx.dfs.TreeNode;

public class lee104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
