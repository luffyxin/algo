package com.dx.util;

import com.google.common.base.Stopwatch;
import java.util.Random;


public class AssistUtil {
    /**
     * 交换数组里面两个数的位置
     * @param arr 数组
     * @param a 下标a
     * @param b 下标b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 生成 从 L -> R 的随机数组
     * @param size 数组大小
     * @param L 左边界值
     * @param R 右边界值
     * @return 生成的随机数组
     */
    public static int [] generateArr(int size, int L, int R){
        assert R < L;
        int arr [] = new int[size];
        Random random = new Random();
        for(int i = 0;i< size;i++){
            arr[i] = random.nextInt(R - L + 1 )+ L;
        }
        return arr;
    }

}
