package com.uu.leecode.n2;

/**
 * @desc 链表定义
 * @author liuph
 * @date 2020/10/16 16:50
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
