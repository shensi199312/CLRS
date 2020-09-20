package com.shensi.clrs.chapter10;

/**
 * 多叉树（长子兄弟法）
 */
public class MultiForkTree {
    public static class Node
    {
        public int data;
        public Node leftChild;
        public Node rightSibling;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void print(Node root)
    {
        if (root != null)
        {
            System.out.println(root.data);
            Node leftChild = root.leftChild;
            if (leftChild != null)
            {
                print(leftChild);
                Node rightSibling = leftChild.rightSibling;
                while (rightSibling != null)
                {
                    print(rightSibling);
                    rightSibling = rightSibling.rightSibling;
                }
            }
        }
    }
}
