package com.shensi.clrs.chapter10;

import java.util.Stack;

/**
 * 非递归遍历二叉树（借助栈）
 */
public class Practice_10_4_3 {

    public static void print(BinaryTree.Node root)
    {
        java.util.Stack<BinaryTree.Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty())
        {
            BinaryTree.Node peek = stack.peek();
            while (peek != null)
            {
                stack.push(peek.left);
                peek = stack.peek();
            }
            stack.pop();
            if (!stack.isEmpty())
            {
                BinaryTree.Node pop = stack.pop();
                System.out.println(pop.data);
                stack.push(pop.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9};
        BinaryTree.Node root = BinaryTree.createRoot(in, 0);
        print(root);
    }
}
