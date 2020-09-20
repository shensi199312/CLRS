package com.shensi.clrs.chapter15;

/**
 * 基于动态规划的斐波拉契数计算
 */
public class Practice_15_1_5 {

    public static int findFibonacci(int n)
    {
        int[] r = new int[n + 1];
        r[0] = 0;
        r[1] = 1;
        for (int i = 2; i <= n; i++) {
            r[i] = r[i - 1] + r[i - 2];
        }
        return r[n];
    }

    public static void main(String[] args) {
        int fibonacci = findFibonacci(8);
        System.out.println(fibonacci);
    }
}
