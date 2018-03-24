package com.demo.sort.load;

import com.demo.sort.annotation.Sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class Main {
    /**
     * 生成随机数组
     *
     * @param len
     * @param range
     * @return
     */
    public static int[] generateArray(int len, int range) {
        if (len < 1) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    /**
     * 输出数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 检查是否排序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            Test test = new Test();
            Class testClass = test.getClass();
            Method[] methods = testClass.getDeclaredMethods();
            for (Method method: methods) {
                if (method.isAnnotationPresent(Sort.class)) {
                    Sort sort = method.getAnnotation(Sort.class);
                    //排序测试
                    int len = 10;
                    int range = 10;
                    int testTimes = 50000;
                    for (; testTimes > 0; --testTimes) {
                        int[] arr = generateArray(len, range);
                        method.invoke(test, (Object) arr);
                        if (!isSorted(arr)) {
                            System.out.println("Wrong Case:");
                            printArray(arr);
                            break;
                        }
                    }
                    if (0 == testTimes) {
                        System.out.println("pass successed: " + sort.value());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
