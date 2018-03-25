package com.demo.exam.meituan;

import java.util.Scanner;

/**
 * 题目：
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。
 * 求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 */
public class Games {
    public static void main() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            int n = cin.nextInt();
            int[] node = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                node[i] = i;
            }
            int a = 0;
            for (int count = 1; count <= n; ++count) {
                //从n个数中选出3 count个数相加
                for (int i = 1; i <= count; ++i) {
                    int sum = 0;
                    for (int j  =1; j <= n; ++j) {
                        sum += j;
                    }
                    if (sum == n) {
                        a++;
                    }
                }
            }
        }
    }
}
