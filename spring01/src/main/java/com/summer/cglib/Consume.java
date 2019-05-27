package com.summer.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基础子类的动态代理实现  cglib
 */
public class Consume {

    public static void main(String[] args) {
        final ProductImpl product = new ProductImpl();

        ProductImpl cglibProduct = (ProductImpl) Enhancer.create(product.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                if ("sale".equals(method.getName())) {
                    Float money = (Float) args[0];
                    returnValue = method.invoke(product, money * 0.8f);
                }

                return returnValue;
            }
        });

        cglibProduct.sale(1000F);

    }
}
