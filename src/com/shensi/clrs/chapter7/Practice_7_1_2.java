package com.shensi.clrs.chapter7;

import com.shensi.clrs.Tool;

/**
 * 快速排序(存在相同元素)
 */
public class Practice_7_1_2 {
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
        boolean allEquals = true;
        int i = p - 1;
        int key = args[r];
        for (int j = p; j < r; j++) {
            if (args[j] != key)
            {
                allEquals = false;
                if (args[j] < key)
                {
                    i++;
                    Tool.swap(args, i, j);
                }
            }
        }
        if (allEquals)
        {
            return (p + r) / 2;
        }
        Tool.swap(args, ++i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,3,3,3,3,3};
        QuickSort.sort(in, 0, in.length - 1);
        Tool.printArray(in);
    }
}
