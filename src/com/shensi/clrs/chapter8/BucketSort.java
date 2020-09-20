package com.shensi.clrs.chapter8;

import com.shensi.clrs.Tool;

/**
 * 桶排序(非比较排序)
 */
public class BucketSort {

    public static class Node{
        public float data;
        public Node prev;
        public Node next;

        public Node(float data) {
            this.data = data;
        }
    }

    public static float[] sort(float[] in)
    {
        float[] result = new float[in.length];

        Node[] tmp = new Node[in.length];

        for (int i = 0; i < in.length; i++) {
            float val = in[i];
            int bucket = (int)Math.floor(val * in.length);
            Node node = new Node(val);
            if (tmp[bucket] == null)
            {
                tmp[bucket] = node;
            }else {
                Node cur = tmp[bucket];
                while (val > cur.data)
                {
                    if (cur.next == null)
                    {
                        break;
                    }
                    cur = cur.next;
                }
                if (cur.data > val)
                {
                    Node prev = cur.prev;
                    if (prev == null)
                    {
                        tmp[bucket] = node;
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
        for (int i = 0; i < tmp.length; i++) {
            Node node = tmp[i];
            while (node != null)
            {
                result[cur] = node.data;
                node = node.next;
                cur++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        float[] in = new float[]{0.49f,0.3f,0.3f,0.32f,0.41f,0.52f,0.26f,0.38f,0.57f,0.9f,0.49f};
        float[] out = sort(in);
        Tool.printArray(out);
    }
}
