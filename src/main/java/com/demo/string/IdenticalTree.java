package com.demo.string;

/**
 * 题目：
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 * 解法：
 * 二叉树的深度序列化、KMP查找
 * 时间复杂度：O(n+m)
 * 空间复杂度
 */
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        String a = serialByPre(A);
        String b = serialByPre(B);
        return getIndexOf(a, b) != -1;

    }
    //O(n)
    private String serialByPre(TreeNode node) {
        if (null == node) {
            return "#!";
        }
        String str = node.getVal() + "!";
        str += serialByPre(node.getLeft());
        str += serialByPre(node.getRight());
        return str;
    }
    //KMP O(n + m)
    private int getIndexOf(String a, String b) {
        if (a == null || b == null || b.length() < 1 || a.length() < b.length()) {
            return -1;
        }
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int[] nextB = getNextArray(arrB);
        int indexA = 0;
        int indexB = 0;
        while (indexA <= arrA.length - 1 && indexB <= arrB.length - 1) {
            if (arrA[indexA] == arrB[indexB]) {
                indexA++;
                indexB++;
            } else if (indexB <= 0) {
                indexA++;
            } else {
                indexB = nextB[indexB];
            }
        }
        if (indexB == arrB.length) {
            return indexA - arrB.length;
        }
        return -1;
    }

    private int[] getNextArray(char[] str) {
        if (str.length <= 1) {
            return new int[] {-1};
        }
        int arr[] = new int[str.length];
        arr[0] = -1;
        arr[1] = 0;

        int pos = 2;
        int next = 0;

        while(pos <= str.length - 1) {
            if (str[pos -1] == str[next]) {
                next++;
                arr[pos] = next;
                pos++;
            } else if ( next <= 0 ) {
                arr[pos] = 0;
                pos++;
            } else {
                next = arr[next];
            }
        }
        return arr;
    }
}