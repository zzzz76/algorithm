package com.demo.sort.loader;

import com.demo.sort.annotation.Sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class TestLoader {
    private static final DecimalFormat df = new DecimalFormat("0.00%");

    /**
     * 生成随机数组
     *
     * @param len
     * @param range
     * @return
     */
    private static int[] generateArray(int len, int range) {
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
    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println();
    }

    /**
     * 检查是否排序
     *
     * @param arr
     * @return
     */
    private static boolean isSorted(int[] arr) {
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

    /**
     * 加载实例，完成测试
     *
     * @param object
     */
    public static void load(Object object) {
        try {
            Class testClass = object.getClass();
            Method[] methods = testClass.getDeclaredMethods();
            for (Method method: methods) {
                if (method.isAnnotationPresent(Sort.class)) {
                    Sort sort = method.getAnnotation(Sort.class);
                    System.out.println("Start test: " + sort.value());
                    //排序测试
                    int testFail = 0;
                    int testCount = 0;
                    int testPass = 0;

                    int len;
                    int range = 10;
                    for (int i = 0; i < 50000; ++i) {
                        len = (int) (Math.random() * (range + 1));
                        int[] arr = generateArray(len, range);
                        method.invoke(object, (Object) arr);
                        testCount++;
                        if (!isSorted(arr)) {
                            if (testFail == 0) {
                                System.out.println("Wrong case: ");
                            }
                            if (testFail < 5) {
                                printArray(arr);
                            }
                            if (testFail == 5) {
                                System.out.println("...");
                            }
                            testFail++;
                        } else {
                            testPass++;
                        }
                    }
                    System.out.println(testPass+ "/" + testCount + " " + df.format((double) testPass / testCount) + "passed\n");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
