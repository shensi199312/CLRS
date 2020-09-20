package com.shensi.clrs;

public class Tool {
    public static void printArray(float[] args)
    {
        for (float arg : args) {
            System.out.println(arg);
        }
        System.out.println("-----------");
    }


    public static void printArray(int[] args)
    {
        for (int arg : args) {
            System.out.println(arg);
        }
        System.out.println("-----------");
    }

    public static int clamp(int val, int min, int max)
    {
        return Math.max(Math.min(val, max), min);
    }

    public static void swap(int[] args, int a, int b)
    {
        int tmp = args[a];
        args[a] = args[b];
        args[b] = tmp;
    }
    public static <T> void swap(T[] args, int a, int b)
    {
        T tmp = args[a];
        args[a] = args[b];
        args[b] = tmp;
    }

}
