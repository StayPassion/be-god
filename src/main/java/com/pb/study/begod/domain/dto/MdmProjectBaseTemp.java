/*
 *    Copyright (c) 2018-2025, dmp All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the dmpcloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: dmp
 */

package com.pb.study.begod.domain.dto;

import com.pb.study.begod.validation.Land;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * 经分-项目-基本信息
 *
 * @author dmp code generator
 * @date 2021-12-17 18:34:00
 */
@Data
public class MdmProjectBaseTemp {

	@NotEmpty(message = "项目来源不能为空")
	private String plan;

	/**
	 * 项目来源
	 */
	@NotEmpty(message = "项目来源不能为空", groups = {Land.class})
	private String projectFrom;

}
