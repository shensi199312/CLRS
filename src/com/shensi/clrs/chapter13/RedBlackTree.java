package com.shensi.clrs.chapter13;

public class RedBlackTree {
    public enum Color
    {
        Red,
        Black
    }

    public class Node
    {
        public Integer data;
        public Color color;
        public Node left;
        public Node right;
        public Node parent;

        public Node(Integer data, Color color) {
            this.data = data;
            this.color = color;
        }
    }

    private Node root;
    private Node dummy = new Node(null, Color.Black);

    public RedBlackTree() {
        this.root = dummy;
        this.root.parent = dummy;
    }

    private void leftRotate(Node x)
    {
        Node y = x.right;
        if (y == dummy) return;
        x.right = y.left;
        if (y.left != dummy)
        {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == dummy)
        {
            root = y;
        }else if (x == x.parent.left)
        {
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x)
    {
        Node y = x.left;
        if (y == dummy) return;
        // 将x的左孩子为y的右孩子
        x.left = y.right;
        if (y.right != null)
        {
            y.right.parent = x;
        }

        // 设置y的父节点为x的父节点
        y.parent = x.parent;
        if (x.parent == dummy)
        {
            root = y;
        }else if (x == x.parent.left)
        {
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }

        // 将x设置为y的右孩子
        y.right = x;

        // 设置x的父节点为y
        x.parent = y;
    }

    public void insert(int val)
    {
        Node node = new Node(val, Color.Red);
        node.parent = dummy;


        Node cur = root;
        Node prev = dummy;
        while (cur != dummy)
        {
            prev = cur;
            if (cur.data > val)
            {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }

        node.parent = prev;
        if (prev == dummy)
        {
            root = node;
        }else if (prev.data > val){
            prev.left = node;
        }else {
            prev.right = node;
        }

        node.left = dummy;
        node.right = dummy;
        redBlackFixup(node);
    }

    private void redBlackFixup(Node z)
    {
        while (z.parent.color == Color.Red)
        {
            // 如果z的父节点是z的祖父的左孩子
            if (z.parent == z.parent.parent.left)
            {
                // 叔父y
                Node y = z.parent.parent.right;
                if (y.color == Color.Red) // 情况一:叔父是红色
                {
                    // 父节点和叔父节点设置为红色
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    // 祖父节点设置为红色
                    z.parent.parent.color = Color.Red;
                    // 插入节点上移两层
                    z = z.parent.parent;
                }
                else if (z == z.parent.right) // 情况二:叔父是黑色,插入节点是其父节点的右孩子
                {
                    // 插入节点上移一层
                    z = z.parent;
                    // 左旋
                    leftRotate(z);
                }else { // 情况三:叔父是黑色,插入节点是其父节点的左孩子
                    // 父节点设置为黑色
                    z.parent.color = Color.Black;
                    // 祖父节点设置为红色
                    z.parent.parent.color = Color.Red;
                    // 祖父节点右旋
                    rightRotate(z.parent.parent);
                }
            }else {
                // 叔父y
                Node y = z.parent.parent.left;
                if (y.color == Color.Red) // 情况一:叔父是红色
                {
                    // 父节点和叔父节点设置为红色
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    // 祖父节点设置为红色
                    z.parent.parent.color = Color.Red;
                    // 插入节点上移两层
                    z = z.parent.parent;
                }
                else if (z == z.parent.right) // 情况二:叔父是黑色,插入节点是其父节点的右孩子
                {
                    // 插入节点上移一层
                    z = z.parent;
                    // 左旋
                    leftRotate(z);
                }else { // 情况三:叔父是黑色,插入节点是其父节点的左孩子
                    // 父节点设置为黑色
                    z.parent.color = Color.Black;
                    // 祖父节点设置为红色
                    z.parent.parent.color = Color.Red;
                    // 祖父节点右旋
                    rightRotate(z.parent.parent);
                }
            }
        }
        // 根节点设置为黑色
        root.color = Color.Black;
    }
}
