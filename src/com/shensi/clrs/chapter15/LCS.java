package com.shensi.clrs.chapter15;

/**
 * 最长公共子序列
 */
public class LCS {

    public static class Result
    {
        public int[][] r;
        public String[][] s;

        public Result(int[][] r, String[][] s) {
            this.r = r;
            this.s = s;
        }
    }

    public static Result findLongestCommonSubsequence(char[] a, char[] b){
        int l = a.length;
        int n = b.length;

        int[][] r = new int[l + 1][n + 1];
        String[][] s = new String[l + 1][n + 1];

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1])
                {
                    r[i][j] = r[i - 1][j - 1] + 1;
                    s[i][j] = "cur";
                }
                else if (r[i - 1][j] >= r[i][j - 1])
                {
                    r[i][j] = r[i - 1][j];
                    s[i][j] = "up";
                }
                else {
                    r[i][j] = r[i][j - 1];
                    s[i][j] = "left";
                }
            }
        }

        return new Result(r, s);
    }

    public static void printResult(char[] a, String[][] s, int m, int n)
    {
        String tag = s[m][n];

        if (m == 0 || n == 0)
        {
            return;
        }

        if (tag.equals("cur"))
        {
            printResult(a, s, m - 1, n -1);
            System.out.print(a[m - 1]);
        }
        else if (tag.equals("up"))
        {
            printResult(a, s, m - 1, n);
        }
        else {
            printResult(a, s, m, n - 1);
        }
    }

    public static void main(String[] args) {
        String a = "ABCBDAB";

        String b = "BDCABA";

        Result result = findLongestCommonSubsequence(a.toCharArray(), b.toCharArray());

        printResult(a.toCharArray(), result.s, 7, 6);
    }
}
