package com.shensi.clrs.chapter10;

/**
 * 双向链表
 */
public class DoublyLinkedList {

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

    public void insert(String key, int data)
    {
        Node node = new Node(key, data);
        if (head != null)
        {
            head.prev = node;
        }
        node.next = head;
        head = node;
    }

    public Node search(String key)
    {
        Node cur = head;
        while (cur != null)
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
        Node prev = search.prev;
        Node next = search.next;
        if (prev != null)
        {
            prev.next = next;
        }else {
            head = next;
        }

        if (next != null)
        {
            next.prev = prev;
        }
    }

    public void update(String key, int val)
    {
        Node search = search(key);
        if (search != null)
        {
            search.data = val;
        }
    }

    public void print()
    {
        Node cur = head;
        while (cur != null)
        {
            System.out.println(cur.key + ":" + cur.data);
            cur = cur.next;
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insert("a", 1);
        linkedList.insert("b", 2);
        linkedList.insert("c", 3);

        linkedList.print();

        linkedList.delete("b");

        linkedList.print();

        linkedList.insert("d", 4);

        linkedList.print();

        linkedList.update("d", 5);

        linkedList.print();
    }
}
