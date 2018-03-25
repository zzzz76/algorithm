package com.demo.exam.toutiao;

import java.util.Scanner;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class Maina {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //获取输入
        String[] str = cin.nextLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int k = Integer.valueOf(str[1]);
        String[] str2 = cin.nextLine().split(" ");

        //目标数组
        long[] arr = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            arr[i] = Long.valueOf(str2[i]);
        }
        arr[n] = 0;

        //进行排序
        quickSort(arr, n);

        int top = 0;
        int tail = 0;
        int count = 0;
        while (tail != n) {
            if ((arr[tail] - arr[top]) != k) {
                tail++;
                while (arr[tail] == arr[tail - 1]) {
                    tail++;
                }
            } else {
                count++;
                top++;
                while (arr[top] == arr[top - 1]) {
                    top++;
                }
            }
        }
        System.out.print(count);
    }

    public static void quickSort(long[] A, int n) {
        // write code here
        sort(A, 0, n - 1);
    }

    private static void sort(long[] A, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int middle = (head + tail) / 2;
        middle = quick(A, head, tail, middle);
        sort(A, head, middle - 1);
        sort(A, middle + 1, tail);
    }

    private static int quick(long[] A, int head, int tail, int middle) {
        long[] arr = new long[tail - head + 1];
        int index = 0;
        for (int i = head; i <= tail; ++i) {
            if (A[i] < A[middle]) {
                arr[index++] = A[i];
            }
        }
        int ret = index;
        for (int i = head; i <= tail; ++i) {
            if (A[i] == A[middle]) {
                arr[index++] = A[i];
            }
        }
        for (int i = head; i <= tail; ++i) {
            if (A[i] > A[middle]) {
                arr[index++] = A[i];
            }
        }
        for (int i =0; i<tail -head + 1; ++i) {
            A[head + i] = arr[i];
        }
        return ret + head;
    }
}
