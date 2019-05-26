package com.summer.proxy;

public class ProductImpl implements IProduct {

    public void sale(float money) {
        System.out.println("销售商品,拿到" + money + "元");
    }

    public void afterSale(float money) {
        System.out.println("提供售后,拿到" + money + "元");
    }

}
