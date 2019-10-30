package com.dx.test;

import com.dx.util.AssistUtil;

public class HeapRe {

    private int[] data;

    private int capacity;

    private int count;


    public HeapRe(int capacity) {

        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public void insert(int k) {

        assert count + 1 < capacity;

        data[count + 1] = k;
        count++;
        shiftUp(count);
    }

    public int extractMax() {

        assert count > 0;

        int max = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int k) {

        while (k * 2 <= count) {
            int j = k * 2;

            if (j + 1 <= count && data[j + 1] > data[j]) {
                j++;
            }

            if (data[k] >= data[j]) {
                break;
            }

            AssistUtil.swap(data, j, k);

            k = j;
        }
    }

    private void shiftUp(int k) {
            while (k > 1 && data[k / 2] < data[k]) {
            AssistUtil.swap(data, k / 2, k);
            k /= 2;
        }
    }


    public void heapSort(int arr[]) {

        for (int i : arr) {
            insert(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = extractMax();
        }
    }

    public  HeapRe(int [] arr,int n){
        data = new int[arr.length+1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }
        count = n;

        for ( int i = count/2 ;i >=1 ;i -- ){
            shiftDown(i);
        }
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }


}
