package com.shensi.clrs.chapter9;

import com.shensi.clrs.Tool;

/**
 * 借助快速排序的思路查找min k/top k
 */
public class QuickSelect {

    public static int quickSelectMinK(int[] args, int p, int r, int k)
    {
        if (k > r - p + 1)
        {
            throw new RuntimeException("k must less than (r - p + 1)");
        }

        while (p < r)
//        if (p < r)
        {
            int q = partition(args, p, r);
            if (q - p + 1 == k)
            {
                return args[q];
            }
            else if (q - p + 1 < k)
            {
//                 return quickSelectMinK(args, q + 1, r, k - q + p - 1);
                k = k - q + p - 1;
                p = q + 1;
            }
            else
            {
//                 return quickSelectMinK(args, p, q - 1, k);
                r = q - 1;
            }
        }
        return args[p];
    }

    public static int partition(int[] args, int p, int r)
    {
        int i = p - 1;
        int key = args[r];
        for (int j = p; j <= r - 1; j++) {
            if (args[j] < key)
            {
                i++;
                Tool.swap(args,i,j);
            }
        }
        Tool.swap(args, ++i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,3,41,52,26,38,57,9,49};
        int out = quickSelectMinK(in, 0, in.length - 1, 3);
        System.out.println(out);
    }
}
