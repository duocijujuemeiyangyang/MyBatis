package com.atguigu.mybatis.mapper;

import pojo.User;

public interface UserMapper {


   int insertUser();


   int updataUser();

   int deleteUser();

   //根据id查询用户信息
   User selectUserById();
}
