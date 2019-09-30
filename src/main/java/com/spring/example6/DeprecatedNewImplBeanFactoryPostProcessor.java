package com.spring.example6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecatedNewImplBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();
            try {
                Class<?> clazz = Class.forName(className);
                DeprecatedNewImpl annotation = clazz.getAnnotation(DeprecatedNewImpl.class);
                if (annotation != null) {
                    Class<?> newImpl = annotation.newImpl();
                    beanDefinition.setBeanClassName(newImpl.getName());
                }
            } catch (ClassNotFoundException e) { /*NOP*/}

        }
    }
}
