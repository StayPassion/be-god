package com.pb.study.begod.domain.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

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
@HeadFontStyle(fontHeightInPoints = 9,fontName="微软雅黑",bold= BooleanEnum.FALSE)
//@OnceAbsoluteMerge(firstRowIndex = 0, lastRowIndex = 1, firstColumnIndex = 0, lastColumnIndex = 0)
@HeadStyle(fillForegroundColor = 22, horizontalAlignment = HorizontalAlignmentEnum.LEFT)
public class ArticleDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 序号
     */
    @ExcelProperty(value = {"序号"})
    private String num;

    @ExcelProperty({"a","Id"})
    @ContentStyle(horizontalAlignment= HorizontalAlignmentEnum.LEFT)
    private Long id;

    @ExcelProperty({"a", "Title"})
    private String title;

    @ExcelProperty({"b", "Content"})
    private String content;

    @ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.RIGHT)
    @ExcelProperty({"b", "Money"})
    private String money;
    @ExcelProperty({"b", "date"})
    private Date createDate;
    @ExcelIgnore
    private LocalDateTime updateDate;

}
