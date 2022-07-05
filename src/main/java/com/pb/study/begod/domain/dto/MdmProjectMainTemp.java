package com.pb.study.begod.domain.dto;

import com.pb.study.begod.validation.Land;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * 项目主表实体对象
 *
 * @author bruli
 * @since 14/12/2021
 */
@Data
public class MdmProjectMainTemp {


	@NotEmpty(message = "data1不允许为空")
	private String data1;

	@Valid
	private MdmProjectBaseTemp base;


	@NotEmpty(message = "data2不允许为空",groups = Land.class)
	private String data2;


	@NotEmpty(message = "data3不允许为空")
	private String data3;





}
