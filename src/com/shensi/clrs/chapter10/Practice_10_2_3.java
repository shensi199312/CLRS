package com.shensi.clrs.chapter10;

/**
 * 单向链表实现队列
 */
public class Practice_10_2_3 {
    public class SinglyLinkedList
    {
        public class Node
        {
            public String key;
            public int data;
            public Node prev;
            public Node next;

            public Node(String key, int data) {
                this.key = key;
                this.data = data;
            }
        }

        private Node head;
        private Node tail;

        public void insert(String key, int val)
        {
            Node node = new Node(key, val);
            if (tail == null)
            {
                head = node;
                tail = node;
                head.next = tail;
            }else {
                tail.next = node;
                tail = node;
            }
        }

        public Node deleteFirst()
        {
            Node tmp = head;
            if (head != null)
            {
                head = head.next;
            }
            return tmp;
        }
    }

    private SinglyLinkedList linkedList;

    public Practice_10_2_3() {
        this.linkedList = new SinglyLinkedList();
    }

    public void enqueue(int val)
    {
        linkedList.insert("", val);
    }

    public Integer dequeue()
    {
        SinglyLinkedList.Node node = linkedList.deleteFirst();

        return node == null ? null : node.data;
    }

    public static void main(String[] args) {
        Practice_10_2_3 p = new Practice_10_2_3();
        p.enqueue(1);
        p.enqueue(2);
        p.enqueue(3);
        System.out.println(p.dequeue());
        p.enqueue(4);
        System.out.println(p.dequeue());
    }
}
