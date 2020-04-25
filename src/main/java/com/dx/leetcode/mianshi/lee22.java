package com.dx.leetcode.mianshi;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

public class lee22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode back = head;
        ListNode front = head;
        for (int i = 1; i < k; i++) {
            front = front.next;
        }
        while (front.next != null) {
            back = back.next;
            front = front.next;
        }
        return back;
    }
}
