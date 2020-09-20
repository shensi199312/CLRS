package com.shensi.clrs.chapter10;

/**
 * 使用固定的额外空间遍历二叉树(非递归)
 */
public class Practice_10_4_5 {

    public static void print(BinaryTree.Node root)
    {
        BinaryTree.Node cur = root;
        BinaryTree.Node prev = null;
        while (cur != null)
        {
            System.out.println(cur.data);
            if (cur.left != null)
            {
                prev = cur;
                cur = cur.left;
            }else if (cur.right != null)
            {
                prev = cur;
                cur = cur.right;
            }else {
                // 若当前节点左右孩子都为空
                if (prev == null) break;
                if (cur == prev.left && prev.right != null)
                {
                    // 进入prev节点右孩子
                    cur = prev.right;
                }else {
                    // prev右孩子为空,或当前节点已经是prev的右孩子,将prev节点前移直到能够进入其右孩子
                    while (prev != null)
                    {
                        if (prev.parent != null && prev == prev.parent.left)
                        {
                            break;
                        }
                        prev = prev.parent;
                    }
                    if (prev != null)
                    {
                        prev = prev.parent;
                        cur = prev.right;
                    }else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5,6,7,8,9};
        BinaryTree.Node root = BinaryTree.createRoot(in, 0);
        print(root);
    }
}
