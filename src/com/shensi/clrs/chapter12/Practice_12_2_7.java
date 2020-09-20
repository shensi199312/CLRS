package com.shensi.clrs.chapter12;

public class Practice_12_2_7 {

    public BinarySearchTree.Node minimum(BinarySearchTree.Node root)
    {
        if (root == null) return null;
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    public BinarySearchTree.Node successor(BinarySearchTree.Node root)
    {
        if (root == null) return null;
        if (root.right != null)
        {
            return minimum(root.right);
        }
        BinarySearchTree.Node cur = root;
        BinarySearchTree.Node prev = cur.parent;

        while (prev != null && cur == prev.right)
        {
            cur = prev;
            prev = prev.parent;
        }
        return prev;
    }


    public void inOrderTreeWalk(BinarySearchTree.Node root)
    {
        BinarySearchTree.Node minimum = minimum(root);
        while (minimum != null)
        {
            System.out.println(minimum.data);
            minimum = successor(minimum);
        }
    }
}
