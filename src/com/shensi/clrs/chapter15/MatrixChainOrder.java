package com.shensi.clrs.chapter15;

public class MatrixChainOrder {

    public static class Result
    {
        public int[][] m;
        public int[][] s;

        public Result(int[][] m, int[][] s) {
            this.m = m;
            this.s = s;
        }
    }

    public static Result getMatrixChainOrder(int[] p)
    {
        int n = p.length - 1;

        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < m.length; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) { // l是步长
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                // 计算[i,j]之间的最小标量乘法数
                int minCount = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    // A(i,k) x A(k + 1,j) = r1 * r2 * c2
                    int count = m[i][k] + m[k+1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (count < minCount)
                    {
                        minCount = count;
                        m[i][j] = count;
                        s[i][j] = k;
                    }
                }
            }
        }
        return new Result(m, s);
    }

    public static void print(int[][] s, int i, int j)
    {
        if (i == j)
        {
            System.out.print("A" + i);
        }else {
            System.out.print("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] p = {5,10,3,12,5,50,6};
        Result r = getMatrixChainOrder(p);

        int n = p.length - 1;

        print(r.s, 0, n - 1);

    }
}
