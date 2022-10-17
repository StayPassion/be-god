package com.pb.study.begod.condition;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Description MyConditional
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/08/17 16:38
 */

public class MyConditional extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionalIAnnotation.class.getName());
        Object key = annotationAttributes.get("key");
        Object value = annotationAttributes.get("value");
        if(key == null || value == null){
            return new ConditionOutcome(false, "error");
        }

        //获取environment中的值
        String key1 = context.getEnvironment().getProperty(key.toString());
        if (value.equals(key1)) {
            //如果environment中的值与指定的value一致，则返回true
            return new ConditionOutcome(true, "ok");
        }
        return new ConditionOutcome(false, "error");

    }
}
