package com.dx.leetcode.mianshi;

import java.util.Stack;

public class lee24 {

    public ListNode reverseList(ListNode head) {
        ListNode black = null;
        ListNode front = head;

        while (front != null) {
            ListNode temp = front.next;
            front.next = black;
            black = front;
            front = temp;
        }
        return black;
    }
}
