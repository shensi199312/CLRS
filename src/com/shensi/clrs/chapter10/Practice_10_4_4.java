package com.shensi.clrs.chapter10;

/**
 * 长子兄弟表示的对叉树遍历
 */
public class Practice_10_4_4 {
    public static void main(String[] args) {
        MultiForkTree.Node _1 = new MultiForkTree.Node(1);

        MultiForkTree.Node _2 = new MultiForkTree.Node(2);
        MultiForkTree.Node _3 = new MultiForkTree.Node(3);
        MultiForkTree.Node _4 = new MultiForkTree.Node(4);

        _1.leftChild = _2;
        _2.rightSibling = _3;
        _3.rightSibling = _4;

        MultiForkTree.Node _5 = new MultiForkTree.Node(5);
        MultiForkTree.Node _6 = new MultiForkTree.Node(6);
        MultiForkTree.Node _7 = new MultiForkTree.Node(7);

        _2.leftChild = _5;
        _5.rightSibling = _6;
        _6.rightSibling = _7;

        MultiForkTree.Node _8 = new MultiForkTree.Node(8);
        MultiForkTree.Node _9 = new MultiForkTree.Node(9);

        _3.leftChild = _8;
        _8.rightSibling = _9;

        MultiForkTree.print(_1);
    }
}
