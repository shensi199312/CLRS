package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 插入排序
 */
public class InsertSort {

    public static void sortAsc(int[] in)
    {
        if (in.length <= 1) return;
        for (int i = 1; i < in.length; i++) {
            int val = in[i];
            int j = i - 1;
            while (j >= 0 && val < in[j]){
                in[j + 1] = in[j];
                j--;
            }
            in[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{31,41,59,26,41,58};
        sortAsc(in);
        Tool.printArray(in);
    }
}
