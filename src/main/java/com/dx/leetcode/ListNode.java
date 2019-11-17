package com.dx.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void addTail(ListNode head, int i) {
        if (head == null) {
            head = new ListNode(i);
        }

        while (head.next != null) {
            head = head.next;
        }

        head.next = new ListNode(i);

    }


    public void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }


    }
}
