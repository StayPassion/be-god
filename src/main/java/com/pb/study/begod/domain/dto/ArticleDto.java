package com.pb.study.begod.domain.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ***
 * @since 2022-04-16
 */
@Data
@ColumnWidth(30)
public class ArticleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("Id")
    @ContentStyle(horizontalAlignment= HorizontalAlignmentEnum.LEFT)
    private Long id;

    @ExcelProperty("Title")
    private String title;

    @ExcelProperty("Content")

    private String content;

    @ContentStyle(horizontalAlignment= HorizontalAlignmentEnum.RIGHT)
    @ExcelProperty("Money")
    private String money;

    private Date createDate;
    @ExcelIgnore
    private LocalDateTime updateDate;

}
