package com.shensi.clrs.chapter6;

import com.shensi.clrs.Tool;

/**
 * 最大堆
 */
public class MaxHeap {

    private int[] array;

    private int heapSize;

    public MaxHeap(int capacity)
    {
        array = new int[capacity];
    }

    public MaxHeap(int[] array)
    {
        this.array = array;
        buildHeap();
    }

    private void buildHeap()
    {
        heapSize = array.length;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void heapSort()
    {
        int tmp = heapSize;

        for (int i = heapSize - 1; i > 0; i--) {
            Tool.swap(array, 0, i);
            heapSize--;
            maxHeapify(0);
        }

        heapSize = tmp;
    }

    public void print()
    {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-----------");
    }

    public int maximum()
    {
        return array[0];
    }

    public int extraMaximum()
    {
        if (heapSize < 1)
        {
            throw new RuntimeException("heap is empty");
        }
        int max = array[0];
        Tool.swap(array, 0, heapSize - 1);
        heapSize--;
        maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int val)
    {
        if (val < array[i])
        {
            throw new RuntimeException("increase val smaller than before");
        }

        while (i > 0 && array[parent(i)] < val){
            array[i] = array[parent(i)];
            i = parent(i);
        }
        array[i] = val;
    }

    public void insert(int val)
    {
        int[] _array = new int[array.length + 1];
        System.arraycopy(array, 0, _array, 0, array.length);
        _array[_array.length - 1] = Integer.MIN_VALUE;
        array = _array;
        heapSize++;
        increaseKey(array.length - 1, val);
    }

    public void delete(int i)
    {
        if (i > heapSize - 1)
        {
            throw new RuntimeException("delete element bigger than heap size");
        }

        if (array[i] > array[heapSize - 1])
        {
            array[i] = array[heapSize - 1];
            maxHeapify(i);
        }else
        {
            increaseKey(i, array[heapSize - 1]);
        }
        heapSize--;
    }

    private void maxHeapify(int i)
    {
        if (i > heapSize - 1){
            throw new RuntimeException("heap size less than " + i);
        }

//        ---- recursive version ----
//        int left = left(i);
//
//        int right = right(i);
//
//        int largestVal = array[i];
//
//        int largestIdx = i;
//
//        if (left < heapSize && array[left] > largestVal)
//        {
//            largestVal = array[left];
//            largestIdx = left;
//        }
//
//        if (right < heapSize && array[right] > largestVal)
//        {
//            largestIdx = right;
//        }
//
//        if (largestIdx != i){
//            Tool.swap(array, largestIdx, i);
//            maxHeapify(largestIdx);
//        }

        while (i < heapSize)
        {
            int left = left(i);
            int right = right(i);

            int largestVal = array[i];
            int largestIdx = i;

            if (left < heapSize && array[left] > largestVal)
            {
                largestVal = array[left];
                largestIdx = left;
            }

            if (right < heapSize && array[right] > largestVal)
            {
                largestIdx = right;
            }

            if (largestIdx == i)
            {
                break;
            }

            Tool.swap(array, i, largestIdx);
            i = largestIdx;
        }
    }

    private int parent(int i)
    {
        return (i + 1) / 2 - 1;
    }

    private int left(int i)
    {
        return 2 * i + 1;
    }

    private int right(int i)
    {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{3,41,52,26,38,57,9,49,2,1});
        
        maxHeap.increaseKey(5, 10);

        maxHeap.insert(42);

        maxHeap.delete(2);

        System.out.println(maxHeap.maximum());

        System.out.println("----------");

        maxHeap.extraMaximum();

        maxHeap.print();

        maxHeap.heapSort();

        maxHeap.print();


    }
}
