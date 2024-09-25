package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface User2Mapper {


   int insertUser();


   int updataUser2(User user);

   //int deleteUser2();


   List<User> selectlist();




   Map<String,Object> selectMap();


   List<Map<String,Object>> selectMapList();

   @MapKey("id")
   List<Map<String,Object>> selectMapallList();



   void  delectUserlist(@Param("ids") String ids);




   List<User>  selectuserbytable(@Param("tableName") String tableName);


   void insertuser2(User user);
}
