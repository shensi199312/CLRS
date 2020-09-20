package com.shensi.clrs.chapter15;

import java.util.Arrays;

/**
 * 自顶向下切割并返回切割方案
 */
public class Practice_15_1_4 {
    public static class Result
    {
        public int maxPrice;
        public int[] s;

        public Result(int maxPrice, int[] s) {
            this.maxPrice = maxPrice;
            this.s = s;
        }
    }

    public static Result cutRod(int[] price, int n){
        int[] r = new int[n + 1];
        Arrays.fill(r, -1);
        int[] s = new int[n + 1];
        cutRodAux(price, n, r, s);
        return new Result(r[n], s);
    }

    public static int cutRodAux(int[] price, int n, int[] r, int[] s)
    {
        if (r[n] >= 0)
        {
            return r[n];
        }
        if (n == 0)
        {
            return 0;
        }
        int maxPrice = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int p = (i > price.length - 1 ? cutRodAux(price, i, r, s) : price[i]) +
                    cutRodAux(price, n - i, r, s);
            if (p > maxPrice)
            {
                maxPrice = p;
                s[n] = i;
            }
        }
        r[n] = maxPrice;
        return maxPrice;
    }

    public static void main(String[] args) {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};

        int n = 9;
        Result result = cutRod(price, n);

        System.out.println(result.maxPrice);

        int[] s = result.s;
        int idx = 1;
        while (n > 0)
        {
            System.out.println("段" + idx + ":" + s[n]);
            n = n - s[n];
            idx++;
        }
    }
}
