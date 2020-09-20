package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 借助二分查找优化插入排序
 */
public class Practice_2_3_6 {

    public static void sort(int[] args, int n)
    {
        if (n > 0)
        {
            sort(args, n - 1);
            int target = binarySearch(args, 0, n - 1, args[n]); // O(n * lgn)
            insert(args, n - 1, target, args[n]); // O(n)
        }
    }

    public static int binarySearch(int[] args, int start, int end, int val)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            if (val < args[mid])
            {
                return binarySearch(args, start, mid, val);
            }
            else if(val > args[mid])
            {
                return binarySearch(args, mid + 1, end, val);
            }
            else
            {
                return mid + 1;
            }
        }
        else
        {
            return Tool.clamp(
                val < args[start] ? start - 1 : start + 1,
                start,
                start + 1
            );
        }
    }

    public static void insert(int[] args, int end, int targetIdx, int val)
    {
        if (targetIdx <= end)
        {
            for (int i = end; i >= targetIdx; i--) {
                args[i + 1] = args[i];
            }
        }
        args[targetIdx] = val;
    }

    public static void main(String[] args) {
        int[] in = new int[]{31,41,59,26,41,58};
        sort(in, in.length - 1);
        Tool.printArray(in);
    }
}
