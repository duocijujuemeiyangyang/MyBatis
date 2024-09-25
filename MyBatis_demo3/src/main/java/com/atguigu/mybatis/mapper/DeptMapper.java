package com.atguigu.mybatis.mapper;

import pojo.Dept;

public interface DeptMapper {

    Dept getEmpAndDeptByStepTwo(Integer did);


    Dept getDeptAndEmp(Integer did);
}
