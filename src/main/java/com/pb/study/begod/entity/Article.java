package com.pb.study.begod.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ***
 * @since 2022-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("article")
@ColumnWidth(30)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty("Id")
    private Long id;

    @ExcelProperty("Title")
    private String title;

    @ExcelProperty("Content")
    private String content;

//    @ContentStyle(rightBorderColor= -1)
    @ExcelProperty("Money")
    private BigDecimal money;

    @JsonIgnore
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;
    @JsonIgnore
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    public Article(Long id, String title, String content, BigDecimal money) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.money = money;
    }

    public Article() {
    }
}
