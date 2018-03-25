package com.demo.sort;

import com.demo.sort.annotation.Sort;
import com.demo.sort.loader.TestLoader;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-25
 *
 * 题目：
 * 桶排序C
 * 时间复杂度：O(N)
 * 空间复杂度：O(M)
 * 稳定的排序算法
 */
public class SortTestC {
    public static void main(String[] args) {
        TestLoader.load(new SortTestA());
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    @Sort(value = "countSort")
    public void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    @Sort(value = "radixSort")
    public void radixSort(int[] arr) {
        // write code here
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i <= n -1; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] context = new int[n];
        int index = 0;
        for (int d = 1; max/d != 0;  d *= 10) {
            for (int i = 0; i <= 9; ++i) {
                for (int j = 0; j <= n -1; ++j) {
                    if ((arr[j]/d)% 10 == i) {
                        context[index] = arr[j];
                        index ++;
                    }
                }
            }
            index = 0;
            for (int i = 0; i <= n - 1; ++i) {
                arr[i] = context[i];
            }
        }
    }
}
