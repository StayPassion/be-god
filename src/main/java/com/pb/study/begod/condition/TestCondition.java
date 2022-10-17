package com.pb.study.begod.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Description TestCondition
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/08/17 15:10
 */

@Slf4j
@Component
//@ConditionalOnProperty(prefix="test",name ="condition",havingValue = "true")
@MyConditionalIAnnotation(key = "test.condition", value = "true")
public class TestCondition implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("该类加载了.................");
    }
}
