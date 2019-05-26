package com.summer.proxy;

public interface IProduct {

    /**
     * 销售商品
     *
     * @param money
     */
    void sale(float money);

    /**
     * 售后
     */
    void afterSale(float money);

}
