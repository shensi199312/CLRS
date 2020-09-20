package com.shensi.clrs.chapter10;

/**
 * 带哑节点的双向循环链表
 */
public class DoublyCircularLinkedListWithDummy {

    public class Node
    {
        public String key;
        public Integer data;
        public Node prev;
        public Node next;

        public Node(String key, Integer data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node dummy;

    public DoublyCircularLinkedListWithDummy() {
        dummy = new Node(null, null);
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public void insert(String key, int val)
    {
        Node node = new Node(key, val);
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }

    public Node search(String key)
    {
        Node cur = dummy;
        while (cur != null)
        {
            if (key.equals(cur.key) || cur.next == dummy)
            {
                break;
            }
            cur = cur.next;
        }
        return cur == dummy ? null : cur;
    }

    public void delete(String key)
    {
        Node search = search(key);
        if (search != null)
        {
            search.prev.next = search.next;
            search.next.prev = search.prev;
        }
    }

    public void print()
    {
        Node cur = dummy;
        while (cur != null)
        {
            if (cur != dummy)
            {
                System.out.println(cur.key + ":" + cur.data);
            }
            if (cur.next == dummy) break;
            cur = cur.next;
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedListWithDummy linkedListWithDummy = new DoublyCircularLinkedListWithDummy();
        linkedListWithDummy.insert("a", 1);
        linkedListWithDummy.insert("b", 2);
        linkedListWithDummy.insert("c", 3);

        linkedListWithDummy.print();

        linkedListWithDummy.delete("a");

        linkedListWithDummy.print();

        linkedListWithDummy.insert("d", 4);

        linkedListWithDummy.print();

        linkedListWithDummy.delete("c");

        linkedListWithDummy.print();
    }
}
