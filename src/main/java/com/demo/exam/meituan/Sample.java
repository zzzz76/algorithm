package com.demo.exam.meituan;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            char[] s = cin.nextLine().toCharArray();
            char[] t = cin.nextLine().toCharArray();
            int lenS = s.length;
            int lenT = t.length;
            int count = 0;
            for (int head = 0; head <= lenS -lenT; ++head) {
                for (int top = 0; top < lenT; ++top) {
                    if (s[head + top] != t[top] ) {
                        count++;
                    }
                }

            }
            System.out.print(count);
        }
    }
}
