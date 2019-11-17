package com.dx.binary;


import com.dx.util.AssistUtil;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {

    private class Node {
        E data;
        Node left, right;

        public Node(E e) {
            this.data = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E data) {
        root = add(root, data);
    }

    private Node add(Node root, E data) {

        if (root == null) {
            size++;
            return new Node(data);
        }

        if (root.data.compareTo(data) > 0) {
            root.left = add(root.left, data);
        } else if (root.data.compareTo(data) < 0) {
            root.right = add(root.right, data);
        }

        return root;
    }

    public void inOrder() {

        inOrder(root);
    }

    private void inOrder(Node root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    public E getMin(){

        if(size == 0) {
            return null;
        }

        return getMin(root);
    }

    private E getMin(Node root) {

        if(root.left == null){
            return root.data;
        }
        return  getMin(root.left);
    }

    public E getMax(){

       if(size == 0){
           return null;
       }
       return getMax(root);

    }

    private E getMax(Node root) {

        if(root.right == null){
            return root.data;
        }
        return getMax(root.right);

    }

    public void levelOrder(){

        Queue<Node> dataQ = new LinkedList<>();

        dataQ.add(root);

        while (dataQ.size() != 0){
            Node temp = dataQ.poll();
            System.out.println(temp.data);
            if(temp.left != null){
                dataQ.add(temp.left);
            }
            if(temp.right != null){
                dataQ.add(temp.right);
            }
        }

    }


    public static void main(String[] args) {
        int[] ints = AssistUtil.generateArr(10, 1, 20);
        BST bst = new BST();
        for (int anInt : ints) {
            bst.add(anInt);
        }
        bst.inOrder();
        System.out.println("min:"+bst.getMin());
        System.out.println("max:"+bst.getMax());
    }


}
