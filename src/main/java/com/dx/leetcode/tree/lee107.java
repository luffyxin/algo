package com.dx.leetcode.tree;

import java.util.*;

public class lee107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null){
            return new  LinkedList<>();
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.add(root);

        List<List<Integer>> request = new LinkedList<>();
        TreeNode temp ;
        while (!treeNodeQueue.isEmpty()){

            int count = treeNodeQueue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i< count;i++){
                temp = treeNodeQueue.poll();
                list.add(temp.val);
                if(temp.left != null){
                    treeNodeQueue.add(temp.left);
                }
                if(temp.right != null){
                    treeNodeQueue.add(temp.right);
                }
            }

            request.add(0,list);
        }
        return request;
    }
}
