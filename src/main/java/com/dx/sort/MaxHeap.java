package com.dx.sort;

import com.dx.util.AssistUtil;

public class MaxHeap {
    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr, int n) {

        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }

    }

    public void heapSort2(int arr[]){

        MaxHeap heap = new MaxHeap(arr,arr.length);
        for(int i = arr.length -1 ; i >=0;i--){
            arr[i] = heap.extractMax();
        }

    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void insert(int i) {

        assert count + 1 < capacity;
        data[count + 1] = i;
        count++;
        shiftUp(count);

    }

    int extractMax() {
        assert count > 0;
        int max = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);

        return max;
    }


    private void shiftDown(int k) {
        // 有孩子的时候才继续， 在一个完全二叉树中有孩子，那肯定有左孩子 ： 2 * k
        while (2 * k <= count) {
            // j : 左孩子
            int j = 2 * k;
            // j + 1 ：右孩子 如果有右孩子，并且右孩子比左孩子大，那就要和右孩子交换
            if (j + 1 <= count && data[j] < data[j + 1]) {
                j += 1;
            }
            // 要交换的节点比孩子大的话就不用交换了
            if (data[k] >= data[j]) {
                break;
            }
            // 与孩子进行交换
            AssistUtil.swap(data, k, j);
            k = j;

        }
    }

    public void heapSort(int[] arr) {

        for (int i : arr) {
            insert(i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = extractMax();
        }

    }

    private void shiftUp(int k) {

        while (k > 1 && data[k / 2] < data[k]) {
            AssistUtil.swap(data, k / 2, k);
            k /= 2;
        }

    }

}
