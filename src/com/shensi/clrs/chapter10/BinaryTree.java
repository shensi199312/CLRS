package com.shensi.clrs.chapter10;

/**
 * 二叉树
 */
public class BinaryTree {
    public static class Node
    {
        public int data;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node createRoot(int[] args, int i)
    {
        if (i <= args.length / 2 - 1)
        {
            Node root = new Node(args[i]);

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < args.length)
            {
                Node l = createRoot(args, left);
                l.parent = root;
                root.left = l;
            }
            if (right < args.length)
            {
                Node r = createRoot(args, right);
                r.parent = root;
                root.right = r;
            }
            return root;
        }else {
            return new Node(args[i]);
        }
    }
}
