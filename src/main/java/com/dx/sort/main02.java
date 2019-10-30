package com.dx.sort;

import com.dx.util.AssistUtil;
import com.google.common.base.Stopwatch;


public class main02 {
    public static void main(String[] args) {

        Stopwatch timer = Stopwatch.createUnstarted();


        int[] ints = AssistUtil.generateArr(10000, 0, 10000);


        timer.start();
        mergeSort(ints);
        timer.stop();

        System.out.println(timer);

    }


    public static void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);

    }

    /**
     * 归并排序
     * @param arr 待排数组
     * @param l 左边界
     * @param r 有边界
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     *  合并
     * @param arr 数组
     * @param l 左
     * @param mid 中间
     * @param r 右
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }

    }


    /**
     * 优化的插入排序
     *
     * @param arr
     */
    public static void youInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int min = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > min; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = min;
        }
    }


    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                AssistUtil.swap(arr, j, j - 1);
            }
        }

    }

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= arr[min]) {
                    min = j;
                }
            }
            AssistUtil.swap(arr, i, min);
        }
    }

    /**
     * //冒泡排序
     *
     * @param arr 待排序数组
     */
    public static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    AssistUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
