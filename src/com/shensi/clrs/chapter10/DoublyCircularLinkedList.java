package com.shensi.clrs.chapter10;

/**
 * 双向循环链表
 */
public class DoublyCircularLinkedList {

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
            tail.prev = head;
        }else {
            tail.next = node;
            node.prev = tail;
            node.next = head;
            head.prev = node;
            tail = node;
        }
    }

    public Node search(String key)
    {
        Node cur = head;
        while (cur != null && cur.next != head)
        {
            if (cur.key.equals(key))
            {
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public void delete(String key)
    {
        Node search = search(key);
        if (search != null)
        {
            Node prev = search.prev;
            Node next = search.next;
            if (search == head)
            {
                head = next;
            }

            if (search == tail)
            {
                tail = prev;
            }
            prev.next = next;
            next.prev = prev;
        }
    }

    public void print()
    {
        Node cur = head;

        while (cur != null)
        {
            System.out.println(cur.key + ":" + cur.data);
            if (cur == tail)
            {
                break;
            }
            cur = cur.next;
        }

        System.out.println("-------------");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList linkedList = new DoublyCircularLinkedList();

        linkedList.insert("a", 1);
        linkedList.insert("b", 2);
        linkedList.insert("c", 3);

        linkedList.print();

        linkedList.delete("a");

        linkedList.print();

        linkedList.insert("d", 4);

        linkedList.print();

        linkedList.delete("c");

        linkedList.print();
    }
}
