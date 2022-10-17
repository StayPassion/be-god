package com.pb.study.begod.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description SysLog
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/09/22 21:03
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface SysLog {

}
