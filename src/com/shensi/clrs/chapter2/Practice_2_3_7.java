package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 借助二分查找寻找两数和
 */
public class Practice_2_3_7 {

    public static int[] searchTwoNumSum(int[] args, int sum)
    {
        MergeSort.mergeSort(args, 0, args.length - 1);
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < args.length; i++) {
            if (args[i] > sum) continue;

            int search = BinarySearch.search(
                    args,
                    Math.min(i + 1, args.length - 1),
                    args.length - 1,
                    sum - args[i]
            );

            if (search != -1)
            {
                result[0] = i;
                result[1] = search;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,2,3,4,6,7,8,19,23,78,99,210};
        int[] ints = searchTwoNumSum(in, 300);
        Tool.printArray(ints);
    }

}
