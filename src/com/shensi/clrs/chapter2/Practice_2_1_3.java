package com.shensi.clrs.chapter2;

/**
 * O(n)查询
 */
public class Practice_2_1_3 {

    public static Integer search(int[] a, int v)
    {
        Integer result = null;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v)
            {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        System.out.println(search(a, 7));
    }
}
