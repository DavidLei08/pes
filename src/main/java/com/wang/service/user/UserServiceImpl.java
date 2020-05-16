package com.wang.service.user;

import com.wang.controller.ben.UpdatePasswordBean;
import com.wang.mapper.ExaminationMapper;
import com.wang.mapper.StudentMapper;
import com.wang.mapper.UserMapper;
import com.wang.pojo.Examination;
import com.wang.pojo.Student;
import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ExaminationMapper examinationMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(String stu_id) {
        return userMapper.deleteUser(stu_id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    /**
     * 如果已录入体检信息，就把体检信息、学生信息、用户信息删除；
     * 如果未录入体检信息，就把学生信息、用户信息删除；
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int deleteUserById(Integer id) {

        User user = userMapper.queryUserById(id);
        Student student = studentMapper.queryStudentByStuId(user.getUsername());
        if (student.getIsInput()==1){
            int i = studentMapper.deleteStudent(user.getUsername());
            int i1 = examinationMapper.deleteExamination(student.getStu_id());
            int i2 = userMapper.deleteUserById(id);

            if (i==1 ||i1==1||i2==1){
                return 1;
            }else{
                return 0;
            }
        }else{
            int i = studentMapper.deleteStudent(user.getUsername());
            int i2 = userMapper.deleteUserById(id);

            return i==i2 ? 1 :0;
        }

    }

    @Override
    public int updateUserPassword(UpdatePasswordBean bean) {
        int total = 0;
        if(bean.getConfirmPassword().equals(bean.getNewPassword())) {
            total = userMapper.updatePassword(bean);
        }
        return total;
    }


}
