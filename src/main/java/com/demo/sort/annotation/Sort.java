package com.demo.sort.annotation;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * User: zzzz76
 * Date: 2018-03-24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Sort {
    String value() default "";
}
