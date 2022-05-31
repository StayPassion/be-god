package com.pb.study.begod.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * MybatisObjectHandler
 * @author ZGF
 * @title: MybatisObjectHandler
 * @projectName bmw-ucorp-parent
 * @Date 13/10/2021 15:49
 */
@Configuration
public class MybatisObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createDate", LocalDateTime.now(),metaObject);
        setFieldValByName("updateDate", LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate",LocalDateTime.now(),metaObject);
    }
}
