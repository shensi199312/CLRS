package com.shensi.clrs.chapter8;

import com.shensi.clrs.Tool;

/**
 * 计数排序(非比较排序)
 */
public class CountingSort {

    public static int[] sort(int[] args, int k)
    {
        int[] c = new int[k + 1];

        for (int i = 0; i < args.length; i++) {
            c[args[i]]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }

        // c[i]保存args[i]中每个元素所在的位置

        int[] out = new int[args.length];

        for (int i = args.length - 1; i >= 0; i--) {
            out[c[args[i]] - 1] = args[i];
            // 相同元素位置-1
            c[args[i]]--;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] in = new int[]{0,3,1,1,2,4,5,4,0,3};
        int[] out = CountingSort.sort(in, 5);
        Tool.printArray(out);
    }
}
