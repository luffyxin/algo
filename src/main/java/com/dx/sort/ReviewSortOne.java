package com.dx.sort;

import com.dx.util.AssistUtil;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

/**
 * @author dx
 */
public class ReviewSortOne {


    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);


    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[left + i];
        }
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {

            if (i > mid) {
                arr[k] = temp[j - left];
                j++;
            }else if( j > right){
                arr[k] = temp[i - left];
                i++;
            }
            else if(temp[i - left] > temp[j - left]){
                arr[k] = temp[j-left];
                j++;
            }else {
                arr[k] = temp[i - left];
                i++;
            }

        }


    }


    public static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(arr, left, right);
        quick(arr, left, p - 1);
        quick(arr, p + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int j = left;
        int data = arr[left];
        for (int i = left; i <= right; i++) {
            if (arr[i] < data) {
                AssistUtil.swap(arr, j + 1, i);
                j++;
            }
        }
        AssistUtil.swap(arr, j, left);
        return j;

    }


    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = index;
        }
    }


    public static void select(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int index = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            AssistUtil.swap(arr, index, i);

        }


    }


    public static void bubble(int arr[]) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    AssistUtil.swap(arr, j - 1, j);
                }
            }

        }

    }


    public static void main(String[] args) {

        int[] ints = AssistUtil.generateArr(10, 1, 50);


        mergeSort(ints, 0, ints.length - 1);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }


}
