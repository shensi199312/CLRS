package com.shensi.clrs.chapter3;

/**
 * 最大子数组O(n)
 */
public class Practice_4_1_5 {

    // O(n)
    public static int[] findMaximumSubarray(int[] args)
    {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int curLeft = 0;
        int curRight;

        int left = 0;
        int right = 0;

        for (int i = 0; i < args.length; i++) {
            curRight = i;
            if (sum > 0){
                sum += args[i];
            }
            else
            {
                curLeft = i;
                sum = args[i];
            }
            if (sum > maxSum)
            {
                maxSum = sum;
                left = curLeft;
                right = curRight;
            }
        }

        return new int[]{left, right, maxSum};
    }

    public static void main(String[] args) {
        int[] in = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        // int[] in = new int[]{-1,-2,-3,-4,-5};

        int[] maximumSubarray = findMaximumSubarray(in);

        System.out.println(maximumSubarray[0]);
        System.out.println(maximumSubarray[1]);
        System.out.println(maximumSubarray[2]);
    }

}
