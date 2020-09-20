package com.shensi.clrs.chapter10;

/**
 * 使用2个指针以及一个布尔的数据类型表示"长子兄弟法"
 * 使得任意节点都可以在基于孩子数的线性时间内到达父节点或者其他孩子节点
 */
public class Practice_10_4_6 {
    public class Node
    {
        public int data;
        public Node leftChild;
        public Node rightSibling;
        public boolean isLastSibling;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node parent(Node node)
    {
        while (node != null && !node.isLastSibling)
        {
            node = node.rightSibling;
        }
        return node == null ? null : node.rightSibling;
    }

    public void printAllChildren(Node node)
    {
        Node leftChild = node.leftChild;
        if (leftChild != null)
        {
            System.out.println(leftChild.data);
            Node rightSibling = node.rightSibling;
            while (rightSibling != null)
            {
                System.out.println(rightSibling.data);
                if (rightSibling.isLastSibling) break;
                rightSibling = rightSibling.rightSibling;
            }
        }
    }
}
