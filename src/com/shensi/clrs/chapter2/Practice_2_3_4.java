package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 插入排序（递归）
 */
public class Practice_2_3_4 {

    public static void sort(int[] args, int n)
    {
        if (n > 0){
            sort(args, n - 1);
            insert(args, n); // O(n)
        }
        else {
            // base base
        }
    }

    public static void insert(int[] args, int n)
    {
        int val = args[n];
        int i = n - 1;
        while (i >= 0 && val < args[i])
        {
            args[i + 1] = args[i];
            i--;
        }
        args[i + 1] = val;
    }

    public static void main(String[] args) {
        int[] in = new int[]{31,41,59,26,41,58};
        sort(in, in.length - 1);
        Tool.printArray(in);
    }
}
