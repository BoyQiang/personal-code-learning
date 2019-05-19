package com.study.sort;

import java.util.Objects;

public class LinkedMergeSort {

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedMergeSort linkedMergeSort = new LinkedMergeSort();
        ListNode result = linkedMergeSort.sort(head);
        while (!Objects.isNull(result)) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    public ListNode sort(ListNode head){
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        return merge(head, right);
    }

    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right){
        if (Objects.isNull(left)) {
            return right;
        }
        if (Objects.isNull(right)) {
            return left;
        }
        ListNode head;
        if (left.val <= right.val) {
            head = left;
            head.next = merge(left.next, right);
        } else {
            head = right;
            head.next = merge(left, right.next);
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
