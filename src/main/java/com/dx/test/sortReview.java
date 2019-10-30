package com.dx.test;

import com.dx.util.AssistUtil;

public class sortReview {


    public static void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length - 1);


    }

    private static void mergeSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);


    }

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

    public static void qucikSort(int[] arr) {

        qucikSort(arr, 0, arr.length - 1);

    }

    private static void qucikSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        qucikSort(arr, l, p - 1);
        qucikSort(arr, p + 1, r);


    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] < v) {
                AssistUtil.swap(arr, j + 1, i);
                j++;
            }
        }
        AssistUtil.swap(arr, j, l);
        return j;
    }

    private static void heapSort(int[] arr, int n) {

        for (int i = (n - 1); i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            AssistUtil.swap(arr, i, 0);
            shiftDown(arr, i, 0);

        }


    }

    private static void shiftDown(int[] arr, int n, int k) {

        while (k * 2 + 1 < n) {
            int j = k * 2 + 1;

            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }

            if (arr[k] > arr[j]) {
                break;
            }

            AssistUtil.swap(arr, j, k);

            k = j;


        }

    }


    public static void main(String[] args) {
        int[] ints = AssistUtil.generateArr(10, 0, 100);
        for (int anInt : ints) {
            System.out.print(anInt + "  ");
        }
        System.out.println();

        heapSort(ints,ints.length);

        for (int anInt : ints) {
            System.out.print(anInt + "  ");
        }
    }


}
