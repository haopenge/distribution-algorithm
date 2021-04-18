package com.uu.interview.node;

/**
 * @desc
 * @author liuph
 * @date 2021/04/15 14:45
 */
public class MergeTest {


    //合并链表
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = {1, 3, 6, 8, 23, 34, 56};
        int[] arr2 = {-90, 34, 55, 79, 87, 98, 123, 234, 567};

        Node link1 = new Node();
        Node link2 = new Node();
        Node link3 = new Node();

        getLink(arr1, link1);
        getLink(arr2, link2);

        mergeLink(link1, link2, link3);

        viewLink(link3);
    }

    /**
     * 构建链表
     *
     * @param arr
     * @param link
     */
    public static void getLink(int[] arr, Node link) {

        for (int i = 0; i < arr.length; i++) {
            link.setNumber(arr[i]);
            link.setNext(new Node());
            link = link.getNext();
        }

    }

    /**
     * 输出链表
     *
     * @param link
     */
    public static void viewLink(Node link) {

        while (link.getNumber() != null) {
            System.out.println(link.getNumber());
            link = link.getNext();
        }
    }

    /**
     * 合并链表
     *
     * @param link1
     * @param link2
     * @param link3
     */
    public static void mergeLink(Node link1, Node link2, Node link3) {

        if ((link2.getNumber() != null) && (link1.getNumber() == null || link1.getNumber() >= link2.getNumber())) {
            link3.setNumber(link2.getNumber());

            link3.setNext(new Node());

            link2 = link2.getNext();
            link3 = link3.getNext();

            mergeLink(link1, link2, link3);

        } else if ((link1.getNumber() != null) && (link2.getNumber() == null || link2.getNumber() > link1.getNumber())) {
            link3.setNumber(link1.getNumber());
            link3.setNext(new Node());
            link1 = link1.getNext();
            link3 = link3.getNext();
            mergeLink(link1, link2, link3);
        } else {
            System.out.println("==没有了，结束啦！==");
        }
    }


}
