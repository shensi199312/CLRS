package com.shensi.clrs.chapter10;

/**
 * 两个栈实现一个队列
 */
public class Practice_10_1_6 {

    private Stack stack1;
    private Stack stack2;

    public Practice_10_1_6(int capacity)
    {
        stack1 = new Stack(capacity);
        stack2 = new Stack(capacity);
    }

    public void enqueue(int val){
        if (stack1.isFull())
        {
            throw new RuntimeException("queue is full");
        }
        stack1.push(val);
    }

    public int dequeue()
    {
        if (stack2.isEmpty() && stack1.isEmpty())
        {
            throw new RuntimeException("queue is empty");
        }
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                int pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Practice_10_1_6 p = new Practice_10_1_6(10);
        p.enqueue(1);
        p.enqueue(2);
        p.enqueue(3);
        p.enqueue(4);
        System.out.println(p.dequeue());
        p.enqueue(5);
        System.out.println(p.dequeue());
    }
}
