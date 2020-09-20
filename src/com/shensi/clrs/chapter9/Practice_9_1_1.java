package com.shensi.clrs.chapter9;

/**
 * 查找第二小的数
 */
public class Practice_9_1_1 {
    public static int findSecondMin(int[] args)
    {
        if (args.length == 1){
            return args[0];
        }

        if (args.length == 2)
        {
            return Math.min(args[0], args[1]);
        }

        int min,secondMin;
        if (args[0] < args[1])
        {
            min = args[0];
            secondMin = args[1];
        }else {
            min = args[1];
            secondMin = args[0];
        }

        for (int i = 2; i < args.length; i+=2) {
            int v1 = args[i];
            int v2 = args[i - 1];
            int v = Math.min(v1, v2);
            if (v < secondMin)
            {
                if (v < min)
                {
                    min = v;
                    secondMin = Math.min(Math.min(min, v1), v2);
                }else {
                    secondMin = v;
                }
            }
        }

        return secondMin;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,3,41,52,26,38,57,9,49};
        int secondMin = findSecondMin(in);
        System.out.println(secondMin);
    }
}
