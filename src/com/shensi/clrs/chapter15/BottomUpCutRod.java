package com.shensi.clrs.chapter15;

/**
 * 自底向上钢条切割
 */
public class BottomUpCutRod {

    public static int cutRod(int[] price, int n)
    {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxPrice = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxPrice = Math.max(
                    maxPrice,
                    (j > price.length - 1 ? r[j] : price[j]) + r[i - j]
                );
            }
            r[i] = maxPrice;
        }
        return r[n];
    }

    public static void main(String[] args) {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        System.out.println(cutRod(price, 7));
    }
}
