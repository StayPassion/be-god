package com.pb.study.begod.config;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
@Component
//@Scope("prototype")
public class ArticleDtoTest implements Serializable {

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
