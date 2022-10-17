package com.pb.study.begod.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Student
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/09/06 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;  //名字
    private int score;    //分数
    //省略getter/setter
}
