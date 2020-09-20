package com.shensi.clrs.chapter31;

import java.util.List;
import java.util.Random;

/**
 * Pollard的rho启发式因素分解
 */
public class PollardRho {

    public static void pollardRho(int n)
    {
        int[] result = new int[n + 1];
        int i = 0;
        result[0] = new Random().nextInt(n);
        int y = result[0];
        int k = 2;
        while (true)
        {
            i++;
            result[i] = (result[i - 1] * result[i - 1] - 1) % n;
            int d = EuclidGcd.gcd(y - result[i], n);
            if (d != 1 && d != n)
            {
                System.out.println(d);
            }
            if (i == k){
                y = result[i];
                k = 2 * k;
            }
        }

    }

    public static void main(String[] args) {
        pollardRho(312);
    }
}
