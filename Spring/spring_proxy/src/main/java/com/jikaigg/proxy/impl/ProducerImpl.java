package com.jikaigg.proxy.impl;

import com.jikaigg.proxy.Producer;

public class ProducerImpl implements Producer {
    public void saleProduct(Float fff) {
        System.out.println("卖电脑了。。。" + fff);
    }

    public void salseService() {
        System.out.println("售后了。。。");
    }
}
