package com.shensi.clrs.chapter10;

/**
 * 栈
 */
public class Stack {

    private int[] array;

    private int top = -1;

    public Stack(int capacity)
    {
        array = new int[capacity];
    }

    public boolean isEmpty()
    {
        if (top == -1)
        {
            return true;
        }
        return false;
    }

    public boolean isFull()
    {
        if (top == array.length - 1)
        {
            return true;
        }
        return false;
    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new RuntimeException("stack under flow");
        }
        top--;
        return array[top + 1];
    }

    public void push(int val)
    {
        if (isFull())
        {
            throw new RuntimeException("stack overflow");
        }
        top++;
        array[top] = val;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        // stack.pop();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());

        stack.push(4);
        stack.push(5);
    }
}
