package com.spring.example6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedNewImpl {
    Class<?> newImpl();
}
