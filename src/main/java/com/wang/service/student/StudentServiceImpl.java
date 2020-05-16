package com.wang.service.student;

import com.wang.mapper.StudentMapper;
import com.wang.pojo.Examination;
import com.wang.pojo.Student;
import com.wang.pojo.User;
import com.wang.service.examination.ExaminationService;
import com.wang.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ExaminationService examinationService;

    @Override
    public List<Student> queryStudentList() {
        return studentMapper.queryStudentList();
    }

    @Override
    public Student queryStudentByStuId(String stu_id) {
        return studentMapper.queryStudentByStuId(stu_id);
    }

    @Override
    @Transactional
    public int addStudent(Student student) {

        User user = new User();
        user.setUsername(student.getStu_id());
        user.setPassword("123456");
        user.setPerms("student");
        int i = userService.addUser(user);
        int i1 = studentMapper.addStudent(student);

        return (i==i1) ? 1 : 0;
    }

    @Override
    public int updateStudentIsInput(String stu_id) {
        return studentMapper.updateStudentIsInput(stu_id);
    }

    @Override
    @Transactional
    public int deleteStudent(String stu_id) {
        int i = userService.deleteUser(stu_id);
        int i1 = studentMapper.deleteStudent(stu_id);
        return i==i1 ? 1: 0;
    }

    @Override
    public int updateStudent(Student student) {
        int toatl = studentMapper.updateStudent(student);
        return toatl;
    }

}
