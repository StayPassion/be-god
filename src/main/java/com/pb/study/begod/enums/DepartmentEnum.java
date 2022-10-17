package com.pb.study.begod.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description DepartmentEnum
 * @Author bopeng@deloitte.com.cn
 * @Date 2022/08/01 15:00
 */

public enum DepartmentEnum {
    /**
     * 信用审批涉及部门
     */
    Indirect_Indirect,
    Direct_OEM,
    Direct_Industrial;

    public static List<String> getNameList(){
        List<String> list = new ArrayList<>();
        for (DepartmentEnum departmentEnum:DepartmentEnum.values()){
            list.add(departmentEnum.name());
        }
        return list;
    }
}

