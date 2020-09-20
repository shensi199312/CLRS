package com.shensi.clrs.chapter8;

import com.shensi.clrs.Tool;

/**
 * 基数排序(非比较排序)
 */
public class RadixSort {

    public static class Node
    {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int[] sort(int[] args, int d, int k)
    {
        int[] result = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            result[i] = args[i];
        }

        for (int i = 1; i <= d; i++) {
            Node[] buckets = new Node[k + 1];

            for (int j = 0; j < result.length; j++) {
                int digitK = getDigitK(result[j], d, i);
                Node bucket = buckets[digitK];
                Node node = new Node(result[j]);
                if (bucket == null)
                {
                    buckets[digitK] = node;
                }else {
                    Node cur = buckets[digitK];
                    while (args[j] > cur.data)
                    {
                        if (cur.next == null)
                        {
                            break;
                        }
                        cur = cur.next;
                    }
                    if (cur.data > args[j])
                    {
                        Node prev = cur.prev;
                        if (prev == null)
                        {
                            buckets[digitK] = node;
                        }else {
                            prev.next = node;
                            node.prev = prev;
                        }
                        cur.prev = node;
                        node.next = cur;
                    }else {
                        Node next = cur.next;
                        cur.next = node;
                        node.prev = cur;
                        if (next != null)
                        {
                            next.prev = node;
                            node.next = next;
                        }
                    }
                }
            }

            int cur = 0;
            for (Node bucket : buckets) {
                while (bucket != null)
                {
                    result[cur] = bucket.data;
                    bucket = bucket.next;
                    cur++;
                }
            }
        }

        return result;
    }

    private static int getDigitK(int n, int d, int k){
        for (int i = d;i > k;i--)
        {
            n = n % ((int)Math.pow(10, i - 1));
        }
        return n / ((int)Math.pow(10, k - 1));
    }

    public static void main(String[] args) {
        int[] in = {12345,13245,54321,45321,23451,32451,11111};
        int[] sort = sort(in, 5, 5);
        Tool.printArray(sort);
    }
}
