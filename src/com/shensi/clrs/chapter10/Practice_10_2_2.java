package com.shensi.clrs.chapter10;

/**
 * 单向链表实现栈
 */
public class Practice_10_2_2 {

    private SinglyLinkedList linkedList;

    public Practice_10_2_2() {
        this.linkedList = new SinglyLinkedList();
    }

    public void push(int val)
    {
        linkedList.insert("", val);
    }

    public Integer pop()
    {
        SinglyLinkedList.Node node = linkedList.deleteFirst();
        return node == null ? null : node.data;
    }

    public static void main(String[] args) {
        Practice_10_2_2 p = new Practice_10_2_2();
        p.push(1);
        p.push(2);
        p.push(3);

        System.out.println(p.pop());

        p.push(4);

        System.out.println(p.pop());
    }
}
