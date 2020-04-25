package com.dx.visual;

public class SelectionSortData {

    private int[] numbers;
    // [0,orderedIndex) 是有序的
    public int orderedIndex = -1;
    /**
     * 当前找到的最小元素的索引
     */
    public int currentMinIndex = -1;
    /**
     * 当前正在比较的元素索引
     */
    public int currentCompareIndex = -1;

    public SelectionSortData(int N, int randomBound) {
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * randomBound);
        }
    }


    public int N() {
        return numbers.length;
    }

    public int get(int index) {
        if (index < 0 || index >= numbers.length) {
            try {
                throw new IllegalAccessException("Invalid index to access Sort Data");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return numbers[index];
    }

    public void set(int index,int num) {
        if (index < 0 || index >= numbers.length) {
            try {
                throw new IllegalAccessException("Invalid index to access Sort Data");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        numbers[index] = num;
    }

    public void swap(int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
