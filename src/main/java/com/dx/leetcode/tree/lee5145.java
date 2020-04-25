package com.dx.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class lee5145 {

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(6);
        TreeNode test2 = new TreeNode(7);
        TreeNode test3 = new TreeNode(8);
        TreeNode test4 = new TreeNode(2);
        TreeNode test5 = new TreeNode(7);
        TreeNode test6 = new TreeNode(1);
        TreeNode test7 = new TreeNode(3);

        test1.left = test2;
        test1.right = test3;
        test2.left = test4;
        test2.right = test5;
        test3.left = test6;
        test3.right = test7;

        int i = sumEvenGrandparent(test1);
        System.out.println(i);

    }



    public static int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();

            if (temp.left != null) {
                if(temp.val %2==0){
                    if (temp.left.left != null) {
                        sum += temp.left.left.val;
                    }
                    if (temp.left.right != null) {
                        sum += temp.left.right.val;
                    }
                }
                queue.add(temp.left);
            }
            if (temp.right != null) {

                if(temp.val %2 ==0){
                    if (temp.right.left != null) {
                        sum += temp.right.left.val;
                    }
                    if (temp.right.right != null) {
                        sum += temp.right.right.val;
                    }
                }
                queue.add(temp.right);
            }
        }
        return sum;
    }
}
