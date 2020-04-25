package com.dx.sort;

import com.dx.util.AssistUtil;

public class MyHeap {

    private int data[];
    private int capacity;
    private int count;


    public void insert(int num) {
        assert count + 1 < capacity;
        count++;
        data[count] = num;
        shiftUp(count);
    }


    public int extractMax() {
        assert count > 0;
        int ret = data[0];
//        shiftDown(0);
        count--;
        return ret;
    }

//    private void shiftDown(int i) {
//        int j = i * 2;
//        while (j <= count) {
//            if (j + 1 <= count && data[j + 1] > data[j]) {
//                j++;
//            }
//            if(data[i])
//
//
//        }
//
//
//    }

    private void shiftUp(int count) {
        while (count > 1 && data[count] > data[count / 2]) {
            AssistUtil.swap(data, count, count / 2);
            count /= 2;
        }
    }


}
