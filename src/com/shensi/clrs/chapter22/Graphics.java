package com.shensi.clrs.chapter22;

public class Graphics {

    public static class Vertex
    {
        public int data;
        public Vertex next;

        public Vertex(int data) {
            this.data = data;
        }
    }

    public Vertex[] vertices;

    /**
     * 有向图转置
     */
    public void trans()
    {
        Vertex[] tmp = new Vertex[vertices.length];
        for (int u = 0; u < vertices.length; u++) {
            Vertex v = vertices[u];
            while (v != null)
            {
                Vertex head = tmp[v.data];
                Vertex vertex = new Vertex(u);
                vertex.next = head;
                tmp[v.data] = vertex;
                v = v.next;
            }
        }
        vertices = tmp;
    }

    /**
     * 清除冗余的边和自循环边
     */
    public void clear()
    {
        Vertex[] tmp = new Vertex[vertices.length];
        int n = vertices.length;
        boolean[][] matrix = new boolean[n][n];
        for (int u = 0; u < vertices.length; u++) {
            Vertex v = vertices[u];
            while (v != null)
            {
                if (!matrix[u][v.data] && u != v.data)
                {
                    Vertex head = tmp[u];
                    v.next = head;
                    tmp[u] = v;
                    matrix[u][v.data] = true;
                }
                v = v.next;
            }
        }
        vertices = tmp;
    }

    /**
     * 检查邻接矩阵是否存在通用汇入点
     * @param matrix
     * @return
     */
    public boolean checkUniversalSink(int[][] matrix)
    {
        int i = 1;
        int j = 1;
        int n = matrix.length;
        while (i < n && j < n)
        {
            if (matrix[i][j] == 1)
            {
                i++;
            }else if (matrix[i][j] == 0)
            {
                j++;
            }
        }
        return matrix[i][j] == 1;
    }



    public static void main(String[] args) {
        Vertex _1 = new Vertex(1);
        Vertex _2 = new Vertex(2);
        Vertex _3 = new Vertex(3);
        Vertex _4 = new Vertex(4);
        Vertex _5 = new Vertex(5);
        Vertex _6 = new Vertex(6);
        Vertex _7 = new Vertex(7);


        _2.next = _3;

        _4.next = _5;

        _6.next = _7;

        Vertex[] vertices = new Vertex[8];
        vertices[1] = _2;
        vertices[2] = _4;
        vertices[3] = _6;

        Graphics graphics = new Graphics();

        graphics.vertices = vertices;

        graphics.trans();

        System.out.println(graphics.vertices);
    }
}
