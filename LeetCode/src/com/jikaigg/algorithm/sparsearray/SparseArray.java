package com.jikaigg.algorithm.sparsearray;

import java.lang.reflect.Array;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //1、创建一个原始的二维数组11*11,0表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][6] = 2;
        //输出原始二维数组
        System.out.println("原始的二维数组");
        for (int[] ints : chessArr1) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组
        //1、先遍历二维数组，得到非0数据的个数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                }
            }
        }
//        System.out.println(count);

        int sparseArr[][] = new int[count + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;

        //2、遍历二维数组，将遍历到的数据存入稀疏数组
        int s = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[s][0] = i;
                    sparseArr[s][1] = j;
                    sparseArr[s][2] = chessArr1[i][j];
                    s++;
                }
            }
        }
        System.out.println("得到的稀疏数组");
        for (int[] ints : sparseArr) {
            for (int i : ints) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
