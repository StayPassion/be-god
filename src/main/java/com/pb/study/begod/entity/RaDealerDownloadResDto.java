//package com.pb.study.begod.entity;
//
//import com.alibaba.excel.annotation.ExcelIgnore;
//import com.alibaba.excel.annotation.ExcelProperty;
//import com.alibaba.excel.annotation.format.NumberFormat;
//import com.alibaba.excel.annotation.write.style.ColumnWidth;
//import com.alibaba.excel.annotation.write.style.ContentStyle;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import org.apache.poi.ss.usermodel.FillPatternType;
//
//import java.io.Serializable;
//
///**
// * raDealer下载内容实体类
// */
//@Data
//@ColumnWidth(20)
//public class RaDealerDownloadResDto implements Serializable {
//
//    private static final long serialVersionUID = -9055688425727913844L;
//    @ApiModelProperty(value = "RA编号")
//    @ExcelProperty("RA#")
//    private String raNo;
//
//    @ApiModelProperty(value = "RA项目item的种类，包括Normal（常规RA），Memo（特殊返款RA），Total（各类型综合）三种")
//    @ExcelProperty("RA Category")
//    private String itemCategory;
//
//    @ApiModelProperty(value = "VKH有效年份")
//    @ExcelProperty("Year")
//    @ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 17)
//    private String vkhYear;
//
//
//    @ApiModelProperty(value = "RA英文名称")
//    @ExcelProperty("RA Name")
//    private String raNameEn;
//
//    @ApiModelProperty(value = "通函编号")
//    @ExcelProperty("CL#")
//    private String clNo;
//
//    @ApiModelProperty(value = "政策子类")
//    @ExcelProperty("Policy Category")
//    private String policyCategory;
//
//    @ApiModelProperty(value = "VKH（项目）编号")
//    @ExcelProperty("VKH#")
//    private String vkhNo;
//
//    @ApiModelProperty(value = "RA状态")
//    @ExcelProperty("Status")
//    private String status;
//
//    @ApiModelProperty(value = "VKH 英文名称")
//    @ExcelProperty("VKH Name")
//    private String vkhNameEn;
//
//    @ApiModelProperty(value = "车辆的Legal Entity，包括NSC，BBA")
//    @ExcelProperty("Legal Entity")
//    private String legalEntity;
//
//    @ApiModelProperty(value = "车辆的品牌和分类,目前包括G1-BMW Cars，G3-MINI，G5-BMWi等")
//    @ExcelProperty("Division")
//    private String division;
//
//    @ApiModelProperty(value = "经销商CBU或CKD编号")
//    @ExcelProperty("Dealer")
//    private String dealerCode;
//
//    @ApiModelProperty(value = "经销商名称")
//    @ExcelProperty("Dealer Name")
//    private String dealerName;
//
//    @ApiModelProperty(value = "税码")
//    @ExcelProperty("Tax Code")
//    private String taxCode;
//
//    @ApiModelProperty(value = "税率")
//    @ExcelProperty("Tax Rate")
//    private String taxRate;
//
//    @ApiModelProperty(value = "币种")
//    @ExcelProperty("Currency")
//    private String currency;
//
//    @ApiModelProperty(value = "RA负责人")
//    @ExcelProperty("Responsible")
//    private String responsible;
//
//    @ExcelProperty("Latest Provision Date")
//    private String provisionDate;
//
//    @ApiModelProperty(value = "Provision金额")
//    @ExcelProperty("Provision")
//    private String provision;
//
//    @ApiModelProperty(value = "最新一次Evaluation的版本编号")
//    @ExcelProperty("Evaluation version")
//    private String evaluationVersion;
//
//    @ApiModelProperty(value = "Evaluation的时间")
//    @ExcelProperty("Evaluation Date")
//    private String evaluationDate;
//
//    @ApiModelProperty(value = "该VIN在该RA中对应的支持点数，以百分比形式展示，保留两位小数")
//    @ExcelProperty("Support Level")
//    private String supportLevel;
//
//    @ApiModelProperty(value = "计算后最终享受的Support Level")
//    @ExcelIgnore
//    private String finalSupportLevel;
//
//    @ExcelProperty("Base Amount Type")
//    private String baseAmountType;
//
//    @ApiModelProperty(value = "该VIN的奖金基础")
//    @ExcelProperty("Base Amount")
//    private String baseAmount;
//
//    @ExcelProperty("Action Result/Total")
//    private String actionResult;
//
//    @ExcelProperty("TG Completion Ratio")
//    private String tgCompletionRatio;
//
//    @ExcelProperty("TG AC Ratio")
//    private String tgAcRatio;
//
//    @ApiModelProperty(value = "Evaluation的结果，是否fail")
//    @ExcelProperty("Evaluation Result")
//    private String evaluationResult;
//
//    @ApiModelProperty(value = "sds校验是否通过 passed:Y  failed:N")
//    @ExcelProperty("Support Document Check Result Passed")
//    private String sdsCheckResult;
//
//    @ExcelProperty("Support Document Check Result Failed")
//    private String sdsFailedCount;
//
//   /* @ApiModelProperty(value = "sds校验失败原因")
//    @ExcelProperty("Support Document Fail desc")
//    private String sdsFailDesc;*/
//
//    @ExcelProperty("Rank Result")
//    private String rankResult;
//
//    @ExcelProperty("Support Level by Rank Result")
//    private String supportLevelByRankingResult;
//
//    @ExcelProperty("Not On Top Check Result")
//    private String notOnTopCheckResult;
//
//    @ExcelProperty("Not On Top VKH")
//    private String notOnTopVkh;
//
//    @ApiModelProperty(value = "by VIN进行Memo的比率")
//    @ExcelProperty("MEMO Ratio (By Dealer)")
//    @NumberFormat("#.##%")
//    private String memoByDealerRatio;
//
//    @ApiModelProperty(value = "by VIN进行Memo的金额")
//    @ExcelProperty("MEMO Adjusted Amount (By Dealer)")
//    private String memoByDealerAmount;
//
//    @ApiModelProperty(value = "属于qualified quantity的车辆数")
//    @ExcelProperty("Qualified quantity")
//    private String qualifiedQuantity;
//
//
//    @ApiModelProperty(value = "RA初步calculation的结果")
//    @ExcelProperty("Obligation_G")
//    private String obligationG;
//
//    @ApiModelProperty(value = "RA初步calculation后并计算尾差调整后的金额结果")
//    @ExcelProperty("Adjusted Obligation_G")
//    private String adjustedObligationG;
//
//    @ApiModelProperty(value = "RA调整编号")
//    @ExcelProperty("RJ#")
//    private String adjustmentNo;
//
//    @ApiModelProperty(value = "RA 进行LPC，deduction，Other等调整的金额")
//    @ExcelProperty("Adjusted")
//    private String adjusted;
//
//    @ApiModelProperty(value = "RA 进行手工调整Miscellaneous的金额")
//    @ExcelProperty("Adjusted (Manual)")
//    private String adjustedManual;
//
//    @ApiModelProperty(value = "每台车均摊到的调整金额")
//    @ExcelProperty("Adjusted Per Unit")
//    private String adjustedPerUnit;
//
//    @ApiModelProperty(value = "Prepay编号")
//    @ExcelProperty("Prepay%")
//    private String prepayNo;
//
//    @ApiModelProperty(value = "B/C/D类第一季度返款金额")
//    @ExcelProperty("Q1")
//    private String q1;
//
//    @ApiModelProperty(value = "B/C/D类第二季度返款金额")
//    @ExcelProperty("Q2")
//    private String q2;
//
//    @ApiModelProperty(value = "B/C/D类第三季度返款金额")
//    @ExcelProperty("Q3")
//    private String q3;
//
//    @ApiModelProperty(value = "B/C/D类第四季度返款金额")
//    @ExcelProperty("Q4")
//    private String q4;
//
//    @ApiModelProperty(value = "最终RA的金额（含税）Final RA(Gross)")
//    @ExcelProperty("Final RA(Gross)")
//    private String finalRaGross;
//
//    @ApiModelProperty(value = "最终RA的金额（不含税）Final RA Support(NET)")
//    @ExcelProperty("Final RA Support(NET)")
//    private String finalRaSupportNet;
//
//    @ApiModelProperty(value = "最终RA的税款")
//    @ExcelProperty("TAX Fee")
//    private String taxFee;
//
//    @ApiModelProperty(value = "最终RA付款Cash类金额")
//    @ExcelProperty("Cash Payment Amount")
//    private String cashPaymentAmount;
//
//    @ApiModelProperty(value = "最终RA付款Deduction类金额")
//    @ExcelProperty("Deduction Payment Amount")
//    private String deductionPaymentAmount;
//
//    @ApiModelProperty(value = "最终RA付款Cash所占百分比")
//    @ExcelProperty("Cash Payment Ratio")
//    private String cashPaymentRatio;
//
//    @ApiModelProperty(value = "最终RA付款Deduction所占百分比")
//    @ExcelProperty("Deduction Payment Ratio")
//    private String deductionPaymentRatio;
//
//    @ApiModelProperty(value = "")
//    @ExcelProperty("Comments")
//    private String comments;
//
//}
