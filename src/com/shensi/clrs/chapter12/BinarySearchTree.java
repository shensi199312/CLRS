package com.shensi.clrs.chapter12;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    public static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    private BinarySearchTree.Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public BinarySearchTree(int[] args)
    {
        // 自顶向下构建二叉搜索树
        // 随机构建二叉搜索树的期望高度是O(lgn),避免出现最坏情况,平衡二叉树退化成链表
        if (args.length > 0)
        {
            root = new BinarySearchTree.Node(args[0]);
            for (int i = 1; i < args.length; i++) {
                insert(args[i]);
            }
        }
    }

    public Node search(int val)
    {
        return searchRecur(root, val);
    }

    public Node searchRecur(BinarySearchTree.Node node, int val)
    {
        if (node == null)
        {
            return null;
        }else if (node.data == val){
            return node;
        }else if (node.data < val) {
            return searchRecur(node.right, val);
        }else {
            return searchRecur(node.left, val);
        }
    }

    public Node _search(int val)
    {
        BinarySearchTree.Node cur = root;
        while (cur != null && cur.data != val)
        {
            cur = cur.data > val ? cur.left : cur.right;
        }
        return cur;
    }

    public Node maximum(BinarySearchTree.Node node)
    {
        BinarySearchTree.Node cur = node;
        while (cur.right != null)
        {
            cur = cur.right;
        }
        return cur;
    }

    public Node minimum(BinarySearchTree.Node node)
    {
        BinarySearchTree.Node cur = node;
        while (cur.left != null)
        {
            cur = cur.left;
        }
        return cur;
    }

    public Node successor(BinarySearchTree.Node node)
    {
        if (node == null) return null;
        // 若当前节点的右孩子不为空,当前节点的后继是右子树的最小值
        if (node.right != null)
        {
            return minimum(node.right);
        }
        Node cur = node;
        Node prev = node.parent;
        // 当前节点上移,直到当前节点是其父节点的左孩子
        while (prev != null && cur == prev.right)
        {
            cur = prev;
            prev = cur.parent;
        }
        return prev;
    }

    public Node predecessor(BinarySearchTree.Node node)
    {
        if (node == null) return null;
        // 如果当前节点的左子树不为空,当前节点的前驱是其左子树的最大值
        if (node.left != null)
        {
            return maximum(node.left);
        }
        Node cur = node;
        Node prev = node.parent;
        while (prev != null && cur == prev.left)
        {
            cur = prev;
            prev = prev.parent;
        }
        return prev;
    }

    public void insert(int val)
    {
        BinarySearchTree.Node cur = root;
        BinarySearchTree.Node p = null;
        while (cur != null)
        {
            p = cur;
            if (val < cur.data)
            {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        BinarySearchTree.Node node = new BinarySearchTree.Node(val);
        node.parent = p;
        if (p == null)
        {
            root = node;
        }else if (val < p.data){
            p.left = node;
        }else {
            p.right = node;
        }
    }

    public void delete(int val)
    {
        Node search = search(val);
        if (search == null) return;
        if (search.left == null)
        {
            // 当删除节点的左孩子为空,直接用其右孩子替换删除节点
            transPlant(search, search.right);
        }else if (search.right == null)
        {
            // 当删除节点的右孩子为空,直接用其左孩子替换删除节点
            transPlant(search, search.left);
        }else {
            Node successor = successor(search);
            // 若删除节点的后继不是其右孩子
            if (successor.parent != search)
            {
                // 使用后继节点的右孩子替换后继节点
                transPlant(successor, successor.right);
                // 设置后继节点的右孩子为删除节点的右孩子
                successor.right = search.right;
                successor.right.parent = search.right;
            }
            // 使用后继节点替换删除节点
            transPlant(search, successor);
            // 设置后继节点的左孩子为删除节点的左孩子
            successor.left = search.left;
            successor.left.parent = successor;
        }
    }

    /**
     * 使用子树v替换u
     * @param u
     * @param v
     * @return
     */
    private void transPlant(BinarySearchTree.Node u, BinarySearchTree.Node v)
    {
        Node up = u.parent;
        if (up == null)
        {
            root = v;
        }
        else if (u == up.left)
        {
            up.left = v;
        }
        else {
            up.right = v;
        }
        if (v != null)
        {
            v.parent = up;
        }
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(new int[]{12, 5, 18, 2, 9, 15, 19, 17});

        System.out.println(binarySearchTree.search(19).data);

        System.out.println(binarySearchTree.maximum(binarySearchTree.root).data);

        System.out.println(binarySearchTree.minimum(binarySearchTree.root).data);

        System.out.println(binarySearchTree.successor(binarySearchTree.search(5)).data);

        System.out.println(binarySearchTree.predecessor(binarySearchTree.search(15)).data);

        binarySearchTree.insert(13);

        System.out.println(binarySearchTree.predecessor(binarySearchTree.search(15)).data);

        System.out.println(binarySearchTree.successor(binarySearchTree.search(17)).data);

        binarySearchTree.delete(18);

        System.out.println(binarySearchTree.successor(binarySearchTree.search(17)).data);

    }
}
