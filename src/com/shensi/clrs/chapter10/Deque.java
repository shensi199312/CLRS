package com.shensi.clrs.chapter10;

import com.shensi.clrs.Tool;

/**
 * 双端队列
 */
public class Deque {

    private int[] array;

    private int head;

    private int tail;

    public Deque(int capacity) {
        array = new int[capacity + 1];
    }

    public boolean isEmpty()
    {
        return head == tail;
    }

    public boolean isFull()
    {
        return head == tail + 1 || (head == 0 && tail == array.length - 1);
    }

    public void headEnqueue(int val)
    {
        if (isFull())
        {
            throw new RuntimeException("deque is full");
        }
        if (head == 0)
        {
            head = array.length - 1;
        }
        else
        {
            head--;
        }
        array[head] = val;
    }

    public void tailEnqueue(int val)
    {
        if (isFull())
        {
            throw new RuntimeException("deque is full");
        }
        array[tail] = val;
        if (tail == array.length - 1)
        {
            tail = 0;
        }
        else
        {
            tail++;
        }
    }

    public int headDequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("deque is empty");
        }
        int result = array[head];
        if (head == array.length  - 1)
        {
            head = 0;
        }else {
            head++;
        }
        return result;
    }

    public int tailDequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("deque is empty");
        }
        int data = array[tail - 1];
        if (tail == 0)
        {
            tail = array.length - 1;
        }else {
            tail--;
        }
        return data;
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.headEnqueue(1);
        deque.headEnqueue(2);
        deque.tailEnqueue(3);

        Tool.printArray(deque.array);

        int i = deque.headDequeue();
        System.out.println(i);

        System.out.println("-----------");

        deque.headEnqueue(4);

        System.out.println(deque.headDequeue());

        System.out.println("-----------");

        deque.tailEnqueue(5);

        System.out.println(deque.tailDequeue());
    }
}
