package com.shensi.clrs.chapter10;

/**
 * 两个队列实现一个栈
 */
public class Practice_10_1_7 {
    private Queue queue1;
    private Queue queue2;

    public Practice_10_1_7(int capacity) {
        queue1 = new Queue(capacity);
        queue2 = new Queue(capacity);
    }

    public void push(int val)
    {
        if (queue1.isFull())
        {
            throw new RuntimeException("stack is full");
        }

        queue2.enqueue(val);
        while (!queue1.isEmpty())
        {
            int data = queue1.dequeue();
            queue2.enqueue(data);
        }
        Queue tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public int pop()
    {
        if (queue1.isEmpty())
        {
            throw new RuntimeException("stack is empty");
        }
        return queue1.dequeue();
    }

    public static void main(String[] args) {
        Practice_10_1_7 p = new Practice_10_1_7(5);
        p.push(1);
        p.push(2);
        p.push(3);
        System.out.println(p.pop());
        System.out.println("----------");
        p.push(4);
        System.out.println(p.pop());
    }
}
