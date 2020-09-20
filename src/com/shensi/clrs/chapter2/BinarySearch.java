package com.shensi.clrs.chapter2;

/**
 * 二分查找
 */
public class BinarySearch {

    // T(n) = T(n / 2) + O(1)
    public static int search(int[] args, int start, int end, int val)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            if (val < args[mid])
            {
                return search(args, start, mid, val);
            }
            else if(val > args[mid])
            {
                return search(args, mid + 1, end, val);
            }
            else {
                return mid;
            }
        }
        else
        {
            // base base
            return args[start] == val ? start : -1;
        }
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,2,3,4,6,7,8,19,23,78,99,210};

        System.out.println(search(in, 0, in.length - 1, 78));
        System.out.println(search(in, 0, in.length - 1, 5));
    }
}
