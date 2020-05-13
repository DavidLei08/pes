package com.wang.mapper;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select(value = "select * from user")
    List<User> queryUserList();

    @Select(value = "select * from user where username=#{username}")
    User queryUserByUsername(String username);

    @Select(value = "select * from user where id=#{id}")
    User queryUserById(Integer id);

    @Insert(value = "insert into user(username,password,perms) values(#{user.username},#{user.password},#{user.perms})")
    int addUser(@Param("user") User user);

    @Delete("delete from user where username =#{stu_id}")
    int deleteUser(String stu_id);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(Integer id);

    @Update("update user set username=#{user.username},password=#{user.password},perms =#{user.perms} where id = #{user.id}")
    int updateUser(@Param("user") User user);
}
