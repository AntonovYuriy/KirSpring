package com.spring.example5;

import javafx.util.Pair;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, List<Pair<Class<?>, Method>>> map = new HashMap<>();
    private Object lock = new Object();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Synchronized.class)) {
                List<Pair<Class<?>, Method>> pairs = map.get(beanName);
                if (pairs == null) {
                    pairs = new ArrayList<>();
                    map.put(beanName, pairs);
                }
                pairs.add(new Pair<>(clazz, method));

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<Pair<Class<?>, Method>> pairs = map.get(beanName);
        if (pairs != null && !pairs.isEmpty()) {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    pairs.get(0).getKey().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            for (Pair<Class<?>, Method> pair : pairs) {
                                if (pair.getValue().getName() == method.getName()) {
                                    synchronized (lock) {
                                        System.out.println("Synch started");
                                        Object result = method.invoke(bean, args);
                                        System.out.println("Synch finished");

                                        return result;
                                    }
                                }
                            }
                            return method.invoke(bean, args);
                        }
                    });
        }
        return bean;
    }
}
