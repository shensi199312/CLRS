package com.shensi.clrs.chapter3;

import java.util.Random;

/**
 * 性能临界点
 */
public class Practice_4_1_3 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += testPerformanceIntersection();
        }
        System.out.println(sum / 10);
    }

    public static int testPerformanceIntersection()
    {
        Random random = new Random();

        int n = 1;

        while (true)
        {
            int[] in = new int[n];
            for (int i = 0; i < in.length; i++) {
                in[i] = random.nextInt();
            }

            long s1 = System.currentTimeMillis();
            int[] r1 = MaximumSubarray.findMaximumSubarray(in, 0, in.length - 1);
            long e1 = System.currentTimeMillis();

            long s2 = System.currentTimeMillis();
            int[] r2 = Practice_4_1_2.findMaximumSubarray(in);
            long e2 = System.currentTimeMillis();

            if (r1[2] == r2[2] && e1 - s1 < e2 - s2) break;

            n++;
        }

        System.out.println(n);
        return n;
    }

}
