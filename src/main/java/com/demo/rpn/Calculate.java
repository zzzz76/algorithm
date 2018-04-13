package com.demo.rpn;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-04-13
 */
public class Calculate {

    /**
     * 计算一个区间内的表达式
     *
     * @param arr
     * @param head
     * @param tail
     * @return
     */
    public static int cal(char[] arr, int head, int tail) {
        int capacity = tail - head + 1;
        char[] symbols = new char[capacity];
        int[] values = new int[capacity];
        int symbolIndex = 0;
        int valueIndex = 0;

        //利用数据结构转存
        for (int i = head; i <= tail; ++i) {
            if (arr[i] <= '9' && arr[i] >= '0') {
                values[valueIndex] *= 10;
                values[valueIndex] += arr[i] - 48;
            }
            if (arr[i] == '(') {
                int nextHead = i + 1;
                while (arr[i] != ')') i++;
                values[valueIndex] = cal(arr, nextHead, i - 1);
            }
            if (i == tail || arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                if (symbolIndex > 0 && symbols[symbolIndex - 1] == '*') {
                    values[valueIndex - 1] *= values[valueIndex];
                    values[valueIndex] = 0;
                    valueIndex--;
                    symbolIndex--;
                }
                if (symbolIndex > 0 && symbols[symbolIndex - 1] == '/') {
                    values[valueIndex - 1] /= values[valueIndex];
                    values[valueIndex] = 0;
                    valueIndex--;
                    symbolIndex--;
                }
                if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                    symbols[symbolIndex] = arr[i];
                    symbolIndex++;
                    valueIndex++;
                }
            }
        }

        int valueTop = 0;
        //遍历符号
        for (int i = 0; i < symbolIndex; ++i) {
            if (symbols[i] == '+') {
                values[valueTop + 1] += values[valueTop];
            }
            if (symbols[i] == '-') {
                values[valueTop + 1] = values[valueTop] - values[valueTop + 1];
            }
            valueTop++;
        }
        return values[valueTop];
    }
}
