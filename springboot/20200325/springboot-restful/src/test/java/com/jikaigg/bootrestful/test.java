package com.jikaigg.bootrestful;

import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test1() {
        // 两次购买的份数
        float j1 = 4028.68f;
        float j2 = 516.42f;
        //两次购买花费的金额
        float m1 = 5000f;
        float m2 = 500f;
        //两次购买时的单位净值
        float s1 = 1.2411f;
        float s2 = 0.9682f;

        //当前净值
//        float a = 0.9697f;
        float a = 0.9911f;

        //当前盈余
        float kuisun = (j1 + j2) * a - 5500;
        System.out.println("当前盈余情况：" + kuisun);

        //两次平均后当时购买的单位净值
        float ax = 5500 / (j1 + j2);
        System.out.println("平均单位净值" + ax);
    }

    @Test
    public void test2() {
        float num = 4545.10f;
        float price = 1.0043f;
        System.out.println("当前盈余:" + (num * price - 5500));
    }
}
