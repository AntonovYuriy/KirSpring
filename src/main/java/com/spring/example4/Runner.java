package com.spring.example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("base-context.xml");
        //SpringBean bean = (SpringBean)context.getBean("springBean");
        SpringBean bean = context.getBean(SpringBean.class);
        SpringBean another = context.getBean(SpringBean.class);
        System.out.println(bean.equals(another));
    }

}
