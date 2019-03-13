package com.yy.dao;

import com.yy.dto.RegUserDto;
import com.yy.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select *  from user where username = #{username}")
    User getUser(@Param("username") String username);

    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    //@SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    int register( RegUserDto regUserDto);
}
