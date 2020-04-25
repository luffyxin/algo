package com.dx.leetcode.mianshi;

public class lee06 {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }

        int temp = 1;
        ListNode  tempHead = head;

        while (head.next != null) {
            head = head.next;
            temp++;
        }

        int[] arr = new int[temp];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = tempHead.val;
            tempHead = tempHead.next;
        }

        return arr;

    }
}
