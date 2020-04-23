package com.jikaigg.lambda;

public class Demo1 {
    interface Printer{
        void printer(String something);
    };
    void printSomething(String str,Printer printer){
        printer.printer(str);
    }


    public static void main(String[] args) {
        //一般方式实现
        /*Printer printer = new Printer() {
            @Override
            public void printer(String something) {
                System.out.println(something);
            }
        };*/
        // lambda表达式实现
        Printer printer = (String str)->{
            System.out.println(str);
        };
        Demo1 demo1 = new Demo1();
        String s = "yaojikai";
        demo1.printSomething(s,printer);

        System.out.println("==========");
        FunctionInterface fi = (ss)->{
            System.out.println("hello"+ss);
        };
        fi.printer("yao");

    }
}
