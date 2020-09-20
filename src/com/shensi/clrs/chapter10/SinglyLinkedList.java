package com.shensi.clrs.chapter10;

/**
 * 单向链表
 */
public class SinglyLinkedList {

    public class Node
    {
        public String key;
        public int data;
        public Node next;

        public Node(String key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node head;

    public void insert(String key, int val)
    {
        Node node = new Node(key, val);
        node.next = head;
        head = node;
    }

    public Node search(String key)
    {
        Node cur = head;
        while (cur != null)
        {
            if (key.equals(cur.key))
            {
                break;
            }
            cur = cur.next;
        }
        return cur;
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

    public Node delete(String key)
    {

        Node cur = head;
        Node prev = null;
        while (cur != null)
        {
            if (cur.key.equals(key))
            {
                Node next = cur.next;
                if (prev != null)
                {
                    prev.next = next;
                }else {
                    head = next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return cur;
    }

    public void update(String key, int val)
    {
        Node search = search(key);
        search.data = val;
    }

    public void reverse()
    {
        Node cur = head;
        Node prev = null;

        while (cur != null)
        {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
    }

    public void print()
    {
        Node cur = head;
        while (cur != null)
        {
            System.out.println(cur.key + ":" + cur.data);
            cur = cur.next;
        }

        System.out.println("------------");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insert("a", 1);
        linkedList.insert("b", 2);
        linkedList.insert("c", 3);

        linkedList.print();

        System.out.println("-----------");

        Node c = linkedList.search("c");
        System.out.println(c.data);

        linkedList.delete("c");

        System.out.println("-----------");

        linkedList.print();

        linkedList.insert("d", 4);

        linkedList.delete("b");

        System.out.println("-----------");

        linkedList.print();
    }
}
