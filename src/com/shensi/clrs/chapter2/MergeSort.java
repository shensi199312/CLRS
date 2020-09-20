package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] args, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            mergeSort(args, start, mid);
            mergeSort(args, mid + 1, end);
            merge(args, start, mid, end);
        }
        else
        {
            // base base
        }
    }

    public static void merge(int[] args, int start, int mid, int end)
    {
        int[] a = new int[mid - start + 1];
        int[] b = new int[end - mid];

        for (int i = start;i <= mid;i++)
        {
            a[i - start] = args[i];
        }

        for (int i = mid + 1;i <= end;i++)
        {
            b[i - mid - 1] = args[i];
        }

        int m = 0;
        int n = 0;

        for (int i = 0;i < end - start + 1;i++)
        {
            if (m > a.length - 1)
            {
                args[start + i] = b[n];
                n++;
                continue;
            }

            if (n > b.length - 1)
            {
                args[start + i] = a[m];
                m++;
                continue;
            }

            if (a[m] <= b[n])
            {
                args[start + i] = a[m];
                m++;
            }else
            {
                args[start + i] = b[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{3,41,52,26,38,57,9,49};
        mergeSort(in, 0, in.length - 1);
        Tool.printArray(in);
    }
}
