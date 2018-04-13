package com.demo.rpn.loader;

import com.demo.rpn.Calculate;

import java.text.DecimalFormat;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-04-13
 */
public class TestLoader {
    private static final DecimalFormat DF = new DecimalFormat("0.00%");
    private static final int ORIGIN_STACK_INDEX = 4;

    private static int testCount = 0;
    private static int testPass = 0;

    private static void verifyBase(boolean equality, int expect, String actual) {
        testCount++;
        if (equality) {
            testPass++;
        } else {
            String className = Thread.currentThread().getStackTrace()[ORIGIN_STACK_INDEX].getClassName();
            int lineNumber = Thread.currentThread().getStackTrace()[ORIGIN_STACK_INDEX].getLineNumber();
            System.err.println(className + ":" + lineNumber
                    + ": expect: " + expect + " actual: " + actual);
        }
    }

    private static void verifyInt(int expect, String actual) {
        char[] arr = actual.toCharArray();
        boolean equality = Calculate.cal(arr, 0, arr.length - 1) == expect;
        verifyBase(equality, expect, actual);
    }

    private static void testSingle() {
        verifyInt(128, "128");
        verifyInt(128, "(128)");
    }

    private static void testAdd() {
        verifyInt(384, "256+128");
        verifyInt(384, "128+256");
        verifyInt(384, "(128+256)");
        verifyInt(384, "128+(128+128)");
        verifyInt(384, "(128+128)+128");
    }

    private static void testSub() {
        verifyInt(128, "256-128");
        verifyInt(-128, "128-256");
        verifyInt(128, "(256-128)");
        verifyInt(-128, "(128-256)");
        verifyInt(0, "128-(256-128)");
        verifyInt(0, "(256-128)-128");
    }

    private static void testMul() {
        verifyInt(256, "16*16");
        verifyInt(256, "(16*16)");
        verifyInt(256, "4*4*4*4");
        verifyInt(256, "4*4*(4*4)");
        verifyInt(256, "4*(4*4)*4");
        verifyInt(256, "(4*4)*4*4");
    }

    private static void testDiv() {
        verifyInt(16, "256/16");
        verifyInt(0, "16/256");
        verifyInt(16, "(256/16)");
        verifyInt(0, "(16/256)");
        verifyInt(1, "256/16/16");
        verifyInt(256, "256/(16/16)");
        verifyInt(1, "(256/16)/16");
    }

    private static void testComplex() {
        verifyInt(0, "4*4*(4-4)");
        verifyInt(0, "(4-4)*4*4");
        verifyInt(0, "4*(4-4)*4");
        verifyInt(128, "4*4*(4+4)");
        verifyInt(128, "(4+4)*4*4");
        verifyInt(128, "4*(4+4)*4");
        verifyInt(0, "4/4*(4-4)");
        verifyInt(0, "(4-4)/4*4");
        verifyInt(0, "4*(4-4)/4");
        verifyInt(2, "4*4/(4+4)");
        verifyInt(8, "(4+4)/4*4");
        verifyInt(8, "4*(4+4)/4");
    }

    private static void testBase() {
        testSingle();
        testAdd();
        testSub();
        testMul();
        testDiv();
        testComplex();
    }

    public static void main(String[] args) {
        testBase();
        System.out.println(testPass + "/" + testCount + " (" + DF.format((double) testPass / testCount) + ") passed\n");
    }
}