package com.dx.sort;

import com.dx.util.AssistUtil;

/**
 * @author dx
 */
public class ReviewSortOne {

    public static void heapSort(int arr[], int n) {

        for (int i = (n - 1) /2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            AssistUtil.swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr, int n, int k) {

        while (k * 2 + 1 < n) {

            int j = k *2 +1;
            if (j + 1 < n && arr[j+1] > arr[j]){
                j++;
            }
            if(arr[j] <= arr[k]){
                return;
            }
            AssistUtil.swap(arr,k,j);
            k = j;

        }


    }


    public static void quickSort(int arr[]) {

        quickSort(arr, 0, arr.length - 1);

    }

    private static void quickSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);

    }

    private static int partition(int[] arr, int l, int r) {

        int v = arr[l];
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] < v) {
                AssistUtil.swap(arr, i, j + 1);
                j++;
            }
        }
        AssistUtil.swap(arr, j, l);
        return j;
    }


    public static void mergeSort(int arr[]) {

        mergeSort(arr, 0, arr.length - 1);

    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int temp[] = new int[r - l + 1];

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


    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }

    }


    public static void selectSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {

            int temp = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[temp]) {
                    temp = j;
                }
            }
            AssistUtil.swap(arr, temp, i);
        }


    }


    public static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    AssistUtil.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] ints = AssistUtil.generateArr(10, 1, 50);


        heapSort(ints, ints.length);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }


}
