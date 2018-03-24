package com.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            int[] context = new int[10];
            char[] numArray = cin.nextLine().toCharArray();
            for (int i = 0; i < numArray.length; ++i) {
                context[numArray[i] - '0']++;
            }
            Integer min = 1;
            while (true) {
                char[] minArray = min.toString().toCharArray();
                int[] contextArray = new int[10];
                for (int i = 0; i < context.length; ++i) {
                    contextArray[i] = context[i];
                }
                for (int i = 0; i < minArray.length; ++i) {
                    --contextArray[minArray[i] - '0'];
                    if (contextArray[minArray[i] - '0'] < 0) {
                        System.out.print(min);
                        return;
                    }
                }
                min++;
            }
        }
    }
}
