package com.shensi.clrs.chapter10;

/**
 * 队列
 */
public class Queue {
    private int[] array;

    private int head;

    private int tail;

    public Queue(int capacity)
    {
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

    public void enqueue(int val)
    {
        if (isFull())
        {
            throw new RuntimeException("queue overflow");
        }

        array[tail] = val;

        if (tail == array.length - 1)
        {
            tail = 0;
        }else {
            tail++;
        }
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("queue underflow");
        }
        int val = array[head];
        if (head == array.length - 1)
        {
            head = 0;
        }else
        {
            head++;
        }
        return val;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(4);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());

        queue.enqueue(5);
        System.out.println(queue.dequeue());

        queue.enqueue(6);
    }
}
