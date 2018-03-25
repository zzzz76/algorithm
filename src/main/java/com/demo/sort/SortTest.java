package com.demo.sort;

import com.demo.sort.annotation.Sort;
import com.demo.sort.loader.TestLoader;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class SortTest {

    public static void main(String[] args) {
        TestLoader.load(new SortTest());
    }

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
        for (int i = arr.length - 1; i >= 0; i--) {
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

    @Sort(value = "insertSort")
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index > 0) {
                if (arr[index - 1] > arr[index]) {
                    swap(arr, index - 1, index);
                    index--;
                } else {
                    break;
                }
            }
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                help[index++] = arr[l++];
            } else {
                help[index++] = arr[r++];
            }
        }
        while (l <= mid) {
            help[index++] = arr[l++];
        }
        while (r <= right) {
            help[index++] = arr[r++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    private void mergeProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeProcess(arr, left, mid);
        mergeProcess(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    @Sort(value = "mergeSort")
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeProcess(arr, 0, arr.length - 1);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left - 1;
        int index = left;
        while (index <= right) {
            if (arr[index] <= arr[right]) {
                swap(arr, ++pivot, index);
            }
            index++;
        }
        return pivot;
    }

    private void quickProcess(int[] arr, int left, int right) {
        if (left < right) {
            int random = left + (int) (Math.random() * (right - left + 1));
            swap(arr, random, right);
            int mid = partition(arr, left, right);
            quickProcess(arr, left, mid - 1);
            quickProcess(arr, mid + 1, right);
        }
    }

    @Sort(value = "quickSort")
    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickProcess(arr, 0, arr.length - 1);
    }

    private void heap(int[] arr, int head, int tail, int node) {
        int leftNode = node *2+1;
        int rightNode = node *2 + 2;
        if (leftNode > tail) {
            return;
        }
        int maxNode = leftNode;
        if (rightNode <= tail) {
            maxNode = arr[leftNode] > arr[rightNode]?leftNode:rightNode;
        }

        if (arr[node] < arr[maxNode]) {
            swap(arr, node, maxNode);
            heap(arr, head, tail, maxNode);
        }
    }

    @Sort(value = "heapSort")
    public void heapSort(int[] arr) {
        // write code here
        // 构建最大堆
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = n/2 -1; i>=0;--i) {
            heap(arr, 0, n-1, i);
        }
        for (int i = n-1; i > 0; --i) {
            swap(arr, i, 0);
            heap(arr, 0, i - 1, 0);
        }
    }

    @Sort(value = "shellSort")
    public void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int feet = arr.length / 2;
        int index = 0;
        while (feet > 0) {
            for (int i = feet; i < arr.length; i++) {
                index = i;
                while (index >= feet) {
                    if (arr[index - feet] > arr[index]) {
                        swap(arr, index - feet, index);
                        index -= feet;
                    } else {
                        break;
                    }
                }
            }
            feet /= 2;
        }
    }
}
