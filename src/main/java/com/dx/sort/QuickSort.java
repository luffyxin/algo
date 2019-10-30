package com.dx.sort;

import com.dx.util.AssistUtil;
import org.checkerframework.checker.units.qual.A;

public class QuickSort {


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] ints = AssistUtil.generateArr(10, 0, 10);

        for (int anInt : ints) {
            System.out.print(anInt + "--");
        }
        System.out.println();

        qs.quickSort(ints, 0, ints.length - 1);

        for (int anInt : ints) {
            System.out.print(anInt + "--");
        }

    }


    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int j = l;
        int v = arr[l];
        for (int i = l; i <= r; i++) {
            if (arr[i] < v) {
                AssistUtil.swap(arr, j + 1, i);
                j++;
            }
        }
        AssistUtil.swap(arr, l, j);

        return j;
    }

    /**
     * 优化重复的值多
     * @param arr arr
     * @param l l
     * @param r r
     * @return j
     */
    private int partition2(int[] arr, int l, int r) {
        int i = l+1;
        int v = arr[l];
        int j = r;
        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;
            if (i > j) break;
            AssistUtil.swap(arr, i, j);
            i++;
            j--;
        }
        AssistUtil.swap(arr, l, j);
        return j;
    }

}
