package com.jikaigg.simple;

import java.util.ArrayList;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 */
public class demo2 {
    public static void main(String[] args) {
        int num = 123;
        String nums = String.valueOf(num);
        System.out.println(nums);
        ArrayList<Character> array = new ArrayList<>();
        for (int i = 0; i < nums.length(); i++) {
            array.add(nums.charAt(i));
        }
        System.out.println(array);
        for (int i = array.size() - 1; i >= 0; i--) {
            int aaa = (int) array.get(i);
            System.out.println(aaa);
            System.out.println(aaa * Math.pow(10, i));
        }

    }
}
