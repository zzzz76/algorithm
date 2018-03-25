package com.demo.sort;

import com.demo.sort.annotation.Sort;
import com.demo.sort.loader.TestLoader;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-25
 *
 * 题目：
 * 比较排序算法B
 * 时间复杂度：O(N*logN)
 */
public class SortTestB {
    public static void main(String[] args) {
        TestLoader.load(new SortTestB());
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
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

    /**
     * 归并排序（后序遍历二叉树）
     * 空间复杂度：O(N + logN)
     * 稳定的排序算法
     *
     * @param arr
     */
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

    /**
     * 快速排序(前序遍历二叉树)
     * 最优空间复杂度：O(logN)
     * 最差空间复杂度：O(N)
     * 最优时间复杂度：O(N*logN)
     * 最差时间复杂度：O(N^2)
     * 不稳定的排序算法
     *
     * @param arr
     */
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

    /**
     * 堆排序
     * 空间复杂度递归/迭代：O(logN)/O(1)
     * 不稳定的排序算法
     *
     * @param arr
     */
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

    /**
     * 希尔排序
     * 空间复杂度：O(1)
     * 不稳定的排序算法
     * @param arr
     */
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
