package com.jikaigg.lambda;

public class Demo3 {
    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        FunctionInterface f = str -> System.out.println(str) ;
        test1("yao",f);
    }
    static void test1(String s,FunctionInterface f){
        f.printer(s);
    }
}
