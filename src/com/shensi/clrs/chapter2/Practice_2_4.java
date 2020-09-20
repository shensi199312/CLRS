package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 借助归并排序思路寻找逆序对
 */
public class Practice_2_4 {

    public static int mergeSortAndCountInversion(int[] args, int start, int end)
    {
        int count = 0;
        if (start < end)
        {
            int mid = (start + end) / 2;
            count += mergeSortAndCountInversion(args, start, mid);
            count += mergeSortAndCountInversion(args, mid + 1, end);
            count += mergeAndCountInversion(args, start, mid, end);
        }
        return count;
    }

    public static int mergeAndCountInversion(int[] args, int start, int mid, int end)
    {
        int count = 0;

        int[] a = new int[mid - start + 1];
        int[] b = new int[end - mid];

        for (int i = 0; i < a.length; i++) {
            a[i] = args[start + i];
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = args[mid + 1 + i];
        }

        int m = 0;
        int n = 0;

        for (int i = 0; i < end - start + 1; i++) {
            if (m > a.length - 1)
            {
                args[start + i] = b[n];
                n++;
            }
            else if(n > b.length - 1)
            {
                args[start + i] = a[m];
                m++;
            }
            else if(a[m] > b[n])
            {
                args[start + i] = a[m];
                // all rest element of b[](include n) can make inversion with a[m]
                count += b.length - n;
                m++;
            }
            else
            {
                args[start + i] = b[n];
                n++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,8,6,1};
        int count = mergeSortAndCountInversion(in, 0, in.length - 1);
        Tool.printArray(in);
        System.out.println(count);
    }
}
