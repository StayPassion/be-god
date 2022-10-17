package com.pb.study.begod.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @TableName bpm_node_config
 */
@Data
public class BpmNodeConfigDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String firstCondition;

    /**
     *
     */
    private BigDecimal secondCondition;

    /**
     *
     */
    private String thirdCondition;

    /**
     *
     */
    private String value;


}