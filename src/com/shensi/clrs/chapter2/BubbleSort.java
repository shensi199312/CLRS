package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] args)
    {
        for (int i = 0;i < args.length;i++)
        {
            for (int j = 0; j < args.length - i - 1; j++) {
                int v1 = args[j];
                int v2 = args[j + 1];
                if (v1 > v2)
                {
                    Tool.swap(args, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,2,3,4,6,7,8,19,23,78,99,210};

        sort(in);

        Tool.printArray(in);
    }
}
