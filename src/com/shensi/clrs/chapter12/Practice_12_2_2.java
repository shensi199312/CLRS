package com.shensi.clrs.chapter12;

public class Practice_12_2_2 {
    public BinarySearchTree.Node minimum(BinarySearchTree.Node node)
    {
        if (node.left == null)
        {
            return node;
        }else {
            return minimum(node.left);
        }
    }


    public BinarySearchTree.Node maximum(BinarySearchTree.Node node)
    {
        if (node.right == null)
        {
            return node;
        }else {
            return maximum(node.right);
        }
    }
}
