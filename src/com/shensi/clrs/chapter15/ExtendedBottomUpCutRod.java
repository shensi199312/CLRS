package com.shensi.clrs.chapter15;

/**
 * 自底向上钢条切割并输出切割方案
 */
public class ExtendedBottomUpCutRod {

    public static class Result
    {
        public int maxPrice;
        public int[] s;

        public Result(int maxPrice, int[] s) {
            this.maxPrice = maxPrice;
            this.s = s;
        }
    }

    public static Result cutRod(int[] price, int n)
    {
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        r[0] = 0;
        s[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxPrice = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                int p = (j > price.length - 1 ? r[j] : price[j]) + r[i - j];
                if (p > maxPrice)
                {
                    maxPrice = p;
                    s[i] = j;
                }
            }
            r[i] = maxPrice;
        }

        return new Result(r[n], s);
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
