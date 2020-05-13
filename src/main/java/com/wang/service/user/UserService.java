package com.wang.service.user;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<User> queryUserList();

    User queryUserByUsername(String username);

    int addUser(User user);

    int deleteUser(String stu_id);

    int updateUser(User user);

    User queryUserById(Integer id);

    int deleteUserById(Integer id);
}
