package com.shensi.clrs.chapter7;

import com.shensi.clrs.Tool;

/**
 * 快速排序(降序)
 */
public class Practice_7_1_4 {

    public static void sort(int[] args, int p, int r)
    {
        if (p < r)
        {
            int q = partition(args, p, r);
            sort(args, p, q - 1);
            sort(args, q + 1, r);
        }
    }

    public static int partition(int[] args, int p, int r)
    {
        int key = args[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (args[j] >= key){
                i++;
                Tool.swap(args, i, j);
            }
        }
        Tool.swap(args, ++i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] in = new int[]{49,3,3,32,41,52,26,38,57,9,49};
        Practice_7_1_4.sort(in, 0, in.length - 1);
        Tool.printArray(in);
    }
}
