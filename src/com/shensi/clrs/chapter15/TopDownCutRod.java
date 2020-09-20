package com.shensi.clrs.chapter15;

import java.util.Arrays;

/**
 * 自顶向下钢条切割
 */
public class TopDownCutRod {

    public static int cutRod(int[] price, int n)
    {
        if (n == 0)
        {
            return 0;
        }
        int maxPrice = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxPrice = Math.max(
                maxPrice,
                price[i] + cutRod(price, n - i)
            );
        }
        return maxPrice;
    }



    public static int _cutRod(int[] price, int n)
    {
        int[] record = new int[n + 1];
        Arrays.fill(record, -1);
        return _cutRodWithRecord(price, n, record);
    }

    public static int _cutRodWithRecord(int[] price, int n, int[] record)
    {
        if (record[n] >= 0)
        {
            return record[n];
        }
        else if (n == 0)
        {
            return 0;
        }
        else
        {
            int maxPrice = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                maxPrice = Math.max(
                    maxPrice,
                    (i > price.length - 1 ? _cutRodWithRecord(price, i, record) : price[i]) + _cutRodWithRecord(price, n - i, record)
                );
            }
            record[n] = maxPrice;
            return maxPrice;
        }

    }

    public static void main(String[] args) {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        long s = System.currentTimeMillis();
        int i = cutRod(price, 10);
        long e = System.currentTimeMillis();
        System.out.println(i + ",cost " + (e - s) + " ms");


        long s1 = System.currentTimeMillis();
        int i1 = _cutRod(price, 10);
        long e1 = System.currentTimeMillis();
        System.out.println(i1 + ",cost " + (e1 - s1) + " ms");
    }
}
