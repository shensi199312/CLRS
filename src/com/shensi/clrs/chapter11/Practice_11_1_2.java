package com.shensi.clrs.chapter11;

public class Practice_11_1_2 {
    private int[] bitmap;

    public Integer search(int k)
    {
        return bitmap[k] == 0 ? null : bitmap[k];
    }

    public void insert(int k)
    {
        bitmap[k] = 1;
    }

    public void delete(int k)
    {
        bitmap[k] = 0;
    }
}
