package com.uu.leecode.n2;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootNode = new ListNode(0);
        ListNode cursor = rootNode;

        int carryVal = 0;

        while (l1 != null || l2 != null || carryVal != 0) {

            int sumVal = (l1 == null?  0:l1.val) + (l2 == null?  0:l2.val) + carryVal;
            if (sumVal >= 10) {
                carryVal = 1;
            }else {
                carryVal = 0;
            }

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;


            l1 = l1 == null? null:l1.next;
            l2 = l2 == null? null:l2.next;
        }

        return rootNode.next;

    }

   public static void main(String[] args) {
       ListNode l1 = new ListNode(2);
       l1.next = new ListNode(4);
       l1.next.next = new ListNode(3);

       ListNode l2 = new ListNode(5);
       l2.next = new ListNode(6);
       l2.next.next = new ListNode(4);

       ListNode resultNode = addTwoNumbers(l1, l2);
       System.out.println(resultNode.val);
       System.out.println(resultNode.next.val);
       System.out.println(resultNode.next.next.val);


       System.out.println(l1.val);
       System.out.println(l1.next.val);
       System.out.println(l1.next.next.val);
   }
}


//leetcode submit region end(Prohibit modification and deletion)


