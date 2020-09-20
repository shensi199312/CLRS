package com.shensi.clrs.chapter6;

import com.shensi.clrs.Tool;

/**
 * 最小堆(优先级队列)
 */
public class MinHeap {

    private int[] array;

    private int heapSize;

    public MinHeap(int capacity){
        array = new int[capacity];
    }

    public MinHeap(int[] data)
    {
        array = data;
        buildHeap();
    }

    public void sort()
    {
        for (int i = heapSize - 1;i >= 0;i--)
        {
            Tool.swap(array, 0, i);
            heapSize--;
            minHeapify(0);
        }
    }

    public int minimum()
    {
        return array[0];
    }

    public int extraMinimum()
    {
        int min = array[0];

        if (heapSize < 1)
        {
            throw new RuntimeException("heap is empty");
        }

        Tool.swap(array, 0, heapSize - 1);
        minHeapify(0);
        heapSize--;

        return min;
    }

    public void insert(int val)
    {
        int[] _array = new int[array.length + 1];
        System.arraycopy(array, 0, _array, 0, array.length);
        _array[_array.length - 1] = Integer.MAX_VALUE;
        array = _array;
        heapSize++;
        decreaseKey(array.length - 1, val);
    }

    public void decreaseKey(int i, int val)
    {
        if (val > array[i])
        {
            throw new RuntimeException("decrease key " + val + " is bigger than before");
        }

        while (i > 0 && val < array[parent(i)])
        {
            array[i] = array[parent(i)];
            i = parent(i);
        }
        array[i] = val;
    }

    public void delete(int i)
    {
        if (i > heapSize - 1)
        {
            throw new RuntimeException("heap size smaller than " + i);
        }

        Tool.swap(array, i, heapSize - 1);
        heapSize--;
        if (array[i] < array[heapSize - 1]){
            minHeapify(i);
        }else{
            decreaseKey(i, array[heapSize - 1]);
        }
    }


    private void buildHeap()
    {
        heapSize = array.length;
        for (int i = array.length / 2 - 1;i >= 0;i--)
        {
            minHeapify(i);
        }
    }

    private void minHeapify(int i)
    {
        if (i > heapSize)
        {
            throw new RuntimeException(i + " is bigger than heap size");
        }

        while (i < heapSize)
        {
            int left = left(i);
            int right = right(i);

            int smallestVal = array[i];
            int smallestIdx = i;

            if (left < heapSize && array[left] < smallestVal)
            {
                smallestVal = array[left];
                smallestIdx = left;
            }

            if (right < heapSize && array[right] < smallestVal)
            {
                smallestIdx = right;
            }

            if (smallestIdx == i) break;

            Tool.swap(array, i, smallestIdx);

            i = smallestIdx;
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
        MinHeap minHeap = new MinHeap(new int[]{3,41,52,26,38,57,9,49});
        minHeap.decreaseKey(1, 6);
        minHeap.insert(10);
        minHeap.delete(3);
        minHeap.sort();
        Tool.printArray(minHeap.array);
    }
}
