package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 插入排序（降序）
 */
public class Practice_2_1_2 {

    public static void sortDesc(int[] in)
    {
        if (in.length <= 1) return;

        for (int i = 1; i < in.length; i++) {
            int val = in[i];
            int j = i - 1;
            while (j >= 0 && val > in[j])
            {
                in[j + 1] = in[j];
                j--;
            }
            in[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{31,41,59,26,41,58};

        sortDesc(in);
        Tool.printArray(in);
    }
}
