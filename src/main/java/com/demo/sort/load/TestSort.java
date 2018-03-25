package com.demo.sort.load;

import com.demo.sort.annotation.Sort;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class TestSort {

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    @Sort(value = "bubbleSort")
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    @Sort(value = "selectSort")
    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mini = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            mini = i;
            for (int j = i + 1; j < arr.length; j++) {
                mini = arr[mini] > arr[j] ? j : mini;
            }
            swap(arr, i, mini);
        }
    }


}
