package com.shensi.clrs.chapter10;

/**
 * 递归遍历二叉树
 */
public class Practice_10_4_2 {


    public static void print(BinaryTree.Node root)
    {
        if (root != null)
        {
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9};
        BinaryTree.Node root = BinaryTree.createRoot(in, 0);
        print(root);
    }
}
