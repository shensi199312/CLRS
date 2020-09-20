package com.shensi.clrs.chapter31;

/**
 * 欧几里得递归法求最大公约数
 */
public class EuclidGcd {

    // gcd(a,b) = gcd(b, a mod b)
    public static int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }

    // gcd(a,b) = ax + by
    public static int[] extendedGcd(int a, int b)
    {
        if (b == 0)
        {
            return new int[]{a, 1, 0};
        }else {
            int[] r = extendedGcd(b, a % b);
            int x = r[1];
            int y = r[2];
            r[1] = y;
            r[2] = x - (a / b) * y;
            return r;
        }
    }

    public static void main(String[] args) {
        int gcd = gcd(30, 21);
        System.out.println(gcd);

        int[] r = extendedGcd(30, 21);
        System.out.println(30 * r[1] + 21 * r[2]);
    }
}
