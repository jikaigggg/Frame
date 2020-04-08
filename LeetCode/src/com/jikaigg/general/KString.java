package com.jikaigg.general;

public class KString {
    public static void main(String[] args) {
        //定义一个字符串
        String str = "YaoJiKai";
        String str1 = "YaoJi";
        String str2 = "YaoJiM";
        String str4 = "yaojikak";

        //1、toUpperCase转换为全大写  ==YAOJIKAI
        System.out.println(str.toUpperCase());

        //2、toLowerCase转换为全小写  ==yaojikai
        System.out.println(str.toLowerCase());

        //3、charAt返回指定索引出的char值  ==o
        System.out.println(str.charAt(2));

        //4、compareTo用字符串和对象（或字符串）进行比较
        /* 如果完全相等返回0；
        * 如果不等，第一种情况是一个字符串完全匹配第二个字符串的前半部分，这种情况返回，另一个字符串比第一个字符串长多少
        * s1=ab; s2=abc;这个时候两个比较返回的为1或-1，看谁和谁比（长的和短的比返回）s2.compareTo(s1)返回1，s1.compareTo(s2)返回-1
        * 第二种情况是两个字符串不相等的第一个自负的差值
        * s1=ab;s2=ad;s2.compareTo(s1)返回2，s1.compareTo(s2)返回-2
        * */
        System.out.println(str.compareTo(str1));
        System.out.println(str1.compareTo(str));
        System.out.println(str.compareTo(str2));
        System.out.println(str2.compareTo(str));
        //5、
        System.out.println(str.compareToIgnoreCase(str4));


        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、
        //5、


    }
}
