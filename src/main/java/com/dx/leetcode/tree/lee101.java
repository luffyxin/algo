package com.dx.leetcode.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class lee101 {

    public boolean isSymmetric(TreeNode root) {

        return isSame(root, root);

    }

    private boolean isSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSame(p.left, q.right) && isSame(p.right, q.left);

    }


}
