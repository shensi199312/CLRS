package com.shensi.clrs.chapter22;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class BFS {

    public enum Color
    {
        White,
        Gray,
        Black
    }

    public static class Vertex
    {
        public int data;
        public Color color;
        public int d;
        public Vertex prev;
        public Vertex next;

        public Vertex(int d) {
            this.d = d;
        }
    }

    public BFS(Vertex[] graphics, Vertex s)
    {
        s.color = Color.Gray;
        s.d = 0;
        s.prev = null;

        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty())
        {
            Vertex u = queue.poll();
            Vertex v = graphics[u.data];
            while (v != null)
            {
                if (v.color == Color.White)
                {
                    v.color = Color.Gray;
                    v.d = u.d + 1;
                    v.prev = u;
                }
                queue.add(v);
                v = v.next;
            }
            u.color = Color.Black;
        }

    }
}
