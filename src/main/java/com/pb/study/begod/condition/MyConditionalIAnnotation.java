package com.pb.study.begod.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Description MyConditionalIAnnotation
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/08/17 16:35
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(MyConditional.class)
public @interface MyConditionalIAnnotation {
    String key();
    String value();
}
