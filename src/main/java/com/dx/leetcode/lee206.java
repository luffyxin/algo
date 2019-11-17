package com.dx.leetcode;

public class lee206 {

    public ListNode reverseList(ListNode head) {

          ListNode cur = head;
          ListNode per  = null;
          ListNode temp = null;
          while (cur != null){

              temp = cur.next;
              cur.next = per;
              per = cur;
              cur = temp;
          }

          return per;

    }

    public static ListNode reverseList2(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = reverseList2(head.next);

        head.next.next = head;

        head.next = null;

        return cur;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addTail(head,2);
        head.addTail(head,3);
        head.addTail(head,4);
        head.addTail(head,5);
        ListNode node = reverseList2(head);

        head.print(node);

    }


}
