package com.shensi.clrs.chapter12;


import com.shensi.clrs.chapter10.BinaryTree;

import java.util.Stack;

/**
 * 中序遍历
 */
public class Practice_12_1_3 {

    public static void inOrderTreeWalk(BinaryTree.Node root)
    {
        Stack<BinaryTree.Node> stack = new Stack<>();
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
            if (!stack.empty())
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
        inOrderTreeWalk(root);
    }
}
