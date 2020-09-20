package com.shensi.clrs.chapter12;

import com.shensi.clrs.chapter10.BinaryTree;
import java.util.LinkedList;

/**
 * 先序遍历、后序遍历、层次遍历
 */
public class Practice_12_1_4 {

    public static void preOrderTreeWalk(BinaryTree.Node root)
    {
        if (root != null)
        {
            System.out.println(root.data);
            preOrderTreeWalk(root.left);
            preOrderTreeWalk(root.right);
        }
    }

    public static void postOrderTreeWalk(BinaryTree.Node root)
    {
        if (root != null)
        {
            postOrderTreeWalk(root.left);
            postOrderTreeWalk(root.right);
            System.out.println(root.data);
        }
    }

    public static void levelOrderTreeWalk(BinaryTree.Node root)
    {
        LinkedList<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            LinkedList<BinaryTree.Node> tmp = new LinkedList<>();
            while (!queue.isEmpty())
            {
                BinaryTree.Node node = queue.pollFirst();
                System.out.println(node.data);
                if (node.left != null)
                {
                    tmp.add(node.left);
                }
                if (node.right != null)
                {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9};
        BinaryTree.Node root = BinaryTree.createRoot(in, 0);

        preOrderTreeWalk(root);

        System.out.println("----------");

        postOrderTreeWalk(root);

        System.out.println("----------");

        levelOrderTreeWalk(root);
    }
}
