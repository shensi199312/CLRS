package com.shensi.clrs.chapter2;

import com.shensi.clrs.Tool;

/**
 * 二进制数组相加
 */
public class Practice_2_1_4 {

    public static int[] binaryAdd(int[] a, int[] b)
    {
        int[] result = new int[Math.max(a.length, b.length) + 1];

        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            int v1 = i > a.length - 1 ? 0 : a[i];
            int v2 = i > b.length - 1 ? 0 : b[i];
            int r = v1 + v2 + carry;
            result[i] = r % 2;
            carry = r / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,1,1};
        int[] b = new int[]{1};

        Tool.printArray(binaryAdd(a, b));
    }
}
