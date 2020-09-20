package com.shensi.clrs.chapter3;

/**
 * 最大子数组O(n ^ 2)
 */
public class Practice_4_1_2 {

    public static int[] findMaximumSubarray(int[] args)
    {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < args.length; i++) {
            int sum = args[i];
            for (int j = i + 1; j < args.length; j++) {
                sum += args[j];
                if (sum > maxSum){
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }
        return new int[]{left, right, maxSum};
    }

    public static void main(String[] args) {
        int[] in = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        int[] maximumSubarray = findMaximumSubarray(in);

        System.out.println(maximumSubarray[0]);
        System.out.println(maximumSubarray[1]);
        System.out.println(maximumSubarray[2]);
    }

}
