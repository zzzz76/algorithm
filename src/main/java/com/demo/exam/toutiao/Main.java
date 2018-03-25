package com.demo.exam.toutiao;

import java.util.Scanner;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            char[] in = cin.nextLine().toCharArray();
            //数字，运算符分开存储
            char[] cal = new char[in.length];
            int[] num = new int[in.length];
            int numTail = 0;
            int calTail = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < in.length; ++i) {
                if (in[i] == '+') {
                    cal[calTail] = '+';
                    calTail++;
                    num[numTail] = Integer.valueOf(stringBuilder.toString());
                    numTail++;
                    stringBuilder = new StringBuilder();
                } else if (in[i] == '-') {
                    cal[calTail] = '-';
                    calTail++;
                    num[numTail] = Integer.valueOf(stringBuilder.toString());
                    numTail++;
                    stringBuilder = new StringBuilder();
                } else if (in[i] == '*') {
                    cal[calTail] = '*';
                    calTail++;
                    num[numTail] = Integer.valueOf(stringBuilder.toString());
                    numTail++;
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(in[i]);
                }
            }
            num[numTail] = Integer.valueOf(stringBuilder.toString());
            calTail--;

            //进行逆波兰计算
            int numIndex = 0;
            int calIndex = 0;
            while (calIndex <= calTail) {
                if (cal[calIndex++] == '+') {
                    num[numIndex + 1] += num[numIndex];
                    numIndex++;
                } else if (cal[calIndex++] == '-') {
                    num[numIndex + 1] -= num[numIndex];
                    numIndex++;
                } else if (cal[calIndex++] == '*') {
                    num[numIndex + 1] *= num[numIndex];
                    numIndex++;
                }
            }

            Integer number = num[numIndex];
            char[] source = number.toString().toCharArray();
            char[][] target = new char[5][0];
            for (int i = 0; i < source.length; ++i) {
                switch (source[i]) {
                    case '0':
                        target = getZero(target);
                        break;
                    case '1':
                        target = getOne(target);
                        break;
                    case '2':
                        target = getTwo(target);
                        break;
                    case '3':
                        target = getThree(target);
                        break;
                    case '4':
                        target = getFour(target);
                        break;
                    case '5':
                        target = getFive(target);
                        break;
                    case '6':
                        target = getSix(target);
                        break;
                    case '7':
                        target = getSeven(target);
                        break;
                    case '8':
                        target = getEight(target);
                        break;
                    case '9':
                        target = getNine(target);
                        break;
                }
            }
            printNum(target);

        }
    }

    private static void printNum(char[][] arr) {
        System.out.println(new String(arr[0]));
        System.out.println(new String(arr[1]));
        System.out.println(new String(arr[2]));
        System.out.println(new String(arr[3]));
        System.out.println(new String(arr[4]));
    }

    //构造0
    private static char[][] getZero(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[0][j] = '6';
                        break;
                    case 1:
                        if (j == len || j == len + 4) {
                            arrNext[1][j] = '6';
                        } else {
                            arrNext[1][j] = ' ';
                        }
                        break;
                    case 2:
                        if (j == len || j == len + 4) {
                            arrNext[2][j] = '6';
                        } else {
                            arrNext[2][j] = ' ';
                        }
                        break;
                    case 3:
                        if (j == len || j == len + 4) {
                            arrNext[3][j] = '6';
                        } else {
                            arrNext[3][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[4][j] = '6';
                        break;
                }
            }

        }
        return arrNext;
    }

    //构造1
    private static char[][] getOne(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 1:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                }
            }
        }
        return arrNext;
    }

    //构造2
    private static char[][] getTwo(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }

    //构造3
    private static char[][] getThree(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }

    //构造4
    private static char[][] getFour(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 1:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                }
            }
        }
        return arrNext;
    }

    //构造5
    private static char[][] getFive(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }

    //构造6
    private static char[][] getSix(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }

    //构造5
    private static char[][] getSeven(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                }
            }
        }
        return arrNext;
    }

    //构造5
    private static char[][] getEight(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }

    //构造9
    private static char[][] getNine(char[][] arr) {
        char[][] arrNext = null;
        int len = arr[0].length;
        if (len != 0) {
            arrNext = new char[5][len + 7];
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < len; ++j) {
                    arrNext[i][j] = arr[i][j];
                }
                arrNext[i][len] = ' ';
                arrNext[i][len + 1] = ' ';
            }
            len += 2;
        } else {
            arrNext = new char[5][len + 5];
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = len; j < len + 5; ++j) {
                switch (i) {
                    case 0:
                        arrNext[i][j] = '6';
                        break;
                    case 1:
                        if (j == len || j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 2:
                        arrNext[i][j] = '6';
                        break;
                    case 3:
                        if (j == len + 4) {
                            arrNext[i][j] = '6';
                        } else {
                            arrNext[i][j] = ' ';
                        }
                        break;
                    case 4:
                        arrNext[i][j] = '6';
                }
            }
        }
        return arrNext;
    }
}


