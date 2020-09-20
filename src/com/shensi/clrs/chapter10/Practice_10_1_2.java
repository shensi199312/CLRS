package com.shensi.clrs.chapter10;

/**
 * 一个数组实现两个栈
 */
public class Practice_10_1_2 {

    public static class DoubleStack
    {
        private final int[] array;

        private int top1;

        private int top2;

        public DoubleStack(int capacity)
        {
            if (capacity < 2)
            {
                throw new RuntimeException("double stack size must bigger than 1");
            }

            array = new int[capacity];

            top1 = -1;

            top2 = array.length;
        }

        public boolean isFull()
        {
            return top1 + 1 == top2;
        }

        public boolean stack1IsEmpty()
        {
            return top1 == -1;
        }

        public boolean stack2IsEmpty()
        {
            return top2 == array.length - 1;
        }

        public void push1(int val)
        {
            if (isFull())
            {
                throw new RuntimeException("double stack is overflow");
            }
            top1++;
            array[top1] = val;
        }

        public void push2(int val)
        {
            if (isFull())
            {
                throw new RuntimeException("double stack is overflow");
            }
            top2--;
            array[top2] = val;
        }

        public int pop1()
        {
            if (stack1IsEmpty())
            {
                throw new RuntimeException("stack one is underflow");
            }
            top1--;
            return array[top1 + 1];
        }

        public int pop2()
        {
            if (stack2IsEmpty())
            {
                throw new RuntimeException("stack one is underflow");
            }
            top2++;
            return array[top2 - 1];
        }
    }

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack(5);

        doubleStack.push1(1);

        doubleStack.push2(2);

        doubleStack.push2(3);

        doubleStack.push1(4);

        doubleStack.push2(5);

        System.out.println(doubleStack.pop1());

        System.out.println(doubleStack.pop2());
    }
}
