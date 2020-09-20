package com.shensi.clrs.chapter10;

/**
 * 单向链表反转（常数的额外空间）
 */
public class Practice_10_2_4 {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insert("a", 1);
        linkedList.insert("b", 2);
        linkedList.insert("c", 3);
        linkedList.insert("d", 4);
        linkedList.print();

        linkedList.reverse();

        linkedList.print();
    }
}
