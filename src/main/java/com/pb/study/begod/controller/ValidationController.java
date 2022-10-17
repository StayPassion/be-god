package com.pb.study.begod.controller;

import com.pb.study.begod.domain.dto.MdmProjectMainTemp;
import com.pb.study.begod.log.SysLog;
import com.pb.study.begod.validation.Land;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Description HelloController
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/03/23 19:02
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@SysLog
public class ValidationController {

    private final Validator validator;

    @PostMapping("/validation")
    public MdmProjectMainTemp helloWorldController(@RequestBody MdmProjectMainTemp mdmProjectMainTemp) {
        Set<ConstraintViolation<MdmProjectMainTemp>> validate = validator.validate(mdmProjectMainTemp);
        Set<ConstraintViolation<MdmProjectMainTemp>> validate1 = validator.validate(mdmProjectMainTemp, Land.class);

        return mdmProjectMainTemp;
    }



}
