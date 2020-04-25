package com.dx;

import com.dx.util.AssistUtil;

public class test823 {
    public static void main(String[] args) {
        int[] ints = AssistUtil.generateArr(10, 1, 100);
        quickSort(ints,0,ints.length-1);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }


    public static void quickSort(int arr[],int l,int r){
        if(l >= r){
            return;
        }

        int p = partation(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);

    }

    private static int partation(int[] arr, int l, int r) {
        int j =l;
        int v= arr[l];

        for (int i = l; i <= r; i++) {
            if(arr[i] < v){
                AssistUtil.swap(arr,i,j+1);
                j++;
            }
        }
        AssistUtil.swap(arr,l,j);
        return j;
    }


    public static void mergeSort(int arr[], int l, int r) {
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
}
