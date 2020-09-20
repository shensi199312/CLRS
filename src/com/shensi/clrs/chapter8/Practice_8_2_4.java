package com.shensi.clrs.chapter8;

/**
 * 统计[a,b]范围内数的个数
 */
public class Practice_8_2_4 {

    public static int count(int[] in, int k, int a, int b)
    {

        if (a <= b)
        {
            int[] c = new int[k + 1];

            for (int i = 0; i < in.length; i++) {
                c[in[i]]++;
            }

            for (int i = 1; i < c.length; i++) {
                c[i] = c[i] + c[i - 1];
            }

            return (b > 0 ? c[b] : 0) - (a > 0 ? c[a - 1] : 0);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] in = new int[]{0,3,1,1,2,4,5,4,0,3};

        System.out.println(count(in, 5, 1, 4));
    }
}
