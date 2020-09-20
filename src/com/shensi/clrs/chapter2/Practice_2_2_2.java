package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 选择排序
 */
public class Practice_2_2_2 {

    public static void sort(int[] args)
    {
        for (int i = 0; i < args.length; i++) {
            swap(args, searchMin(args, i, args.length - 1), i);
        }
    }

    public static int searchMin(int[] args, int start, int end)
    {
        int minVal = args[start];
        int minIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (args[i] < minVal){
                minVal = args[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void swap(int[] args, int a, int b)
    {
        int tmp = args[a];
        args[a] = args[b];
        args[b] = tmp;
    }

    public static void main(String[] args) {
        int[] in = new int[]{31,41,59,26,41,58};
        sort(in);
        Tool.printArray(in);
    }
}
