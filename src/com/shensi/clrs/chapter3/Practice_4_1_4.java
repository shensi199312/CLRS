package com.shensi.clrs.chapter3;

public class Practice_4_1_4 {
    // T(n) = 2T(n / 2) + O(n)
    public static Integer[] findMaximumSubarray(int[] args, int start, int end)
    {
        if (start < end){
            int mid = (start + end) / 2;
            Integer[] leftResult = findMaximumSubarray(args, start, mid);
            Integer[] rightResult = findMaximumSubarray(args, mid + 1, end);
            Integer[] crossResult = findMaximumSubarrayCrossMid(args, start, mid, end);

            if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2])
            {
                return leftResult;
            }
            else if (rightResult[2] >= leftResult[2] && rightResult[2] >= crossResult[2])
            {
                return rightResult;
            }else
            {
                return crossResult;
            }
        }
        else
        {
            return args[start] >= 0 ? new Integer[]{start, start, args[start]} : new Integer[]{null, null, 0};
        }
    }

    public static Integer[] findMaximumSubarrayCrossMid(int[] args, int start, int mid, int end)
    {
        Integer[] result = new Integer[]{-1, -1, Integer.MIN_VALUE};

        int maxLeftSum = 0;
        int leftSum = 0;
        Integer maxLeftIdx = mid - 1;
        for (int i = mid; i >= start; i--) {
            leftSum += args[i];
            if (leftSum > maxLeftSum)
            {
                maxLeftIdx = i;
                maxLeftSum = leftSum;
            }
        }

        int maxRightSum = 0;
        int rightSum = 0;
        Integer maxRightIdx = mid + 1;
        for (int i = mid + 1; i <= end; i++) {
            rightSum += args[i];
            if (rightSum > maxRightSum){
                maxRightIdx = i;
                maxRightSum = rightSum;
            }
        }

        result[0] = maxLeftIdx;
        result[1] = maxRightIdx;
        result[2] = maxLeftSum + maxRightSum;

        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        Integer[] maximumSubarray = findMaximumSubarray(in, 0, in.length - 1);

        System.out.println(maximumSubarray[0]);
        System.out.println(maximumSubarray[1]);
        System.out.println(maximumSubarray[2]);
    }
}
