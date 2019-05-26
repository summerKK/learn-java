package com.summer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consume {

    public static void main(String[] args) {
        final ProductImpl product = new ProductImpl();
        IProduct instance = (IProduct) Proxy.newProxyInstance(ProductImpl.class.getClassLoader(), ProductImpl.class.getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        if ("sale".equals(method.getName())) {
                            Float money = (Float) args[0];
                            returnValue = method.invoke(product, money * 0.8f);
                        }

                        return returnValue;
                    }
                });

        instance.sale(1000f);

    }
}
