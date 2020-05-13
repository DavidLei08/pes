package com.wang.service.student;

import com.wang.pojo.Examination;
import com.wang.pojo.Student;
import com.wang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> queryStudentList();

    Student queryStudentByStuId(String stu_id);

    int addStudent(@Param("student") Student student);

    int updateStudentIsInput(String stu_id);

    int deleteStudent(String stu_id);

}
