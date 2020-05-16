package com.wang.mapper;

import com.wang.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select(value = "select * from student")
    List<Student> queryStudentList();

    @Select(value = "select * from student where stu_id=#{stu_id}")
    Student queryStudentByStuId(String stu_id);

    @Insert(value = "insert into student (stu_id,name,gender,dept_name,grade,isInput) values(#{student.stu_id},#{student.name},#{student.gender},#{student.dept_name},#{student.grade},0)")
    int addStudent(@Param("student") Student student);

    @Update(value = "update student set isInput=1 where stu_id=#{stu_id}")
    int updateStudentIsInput(String stu_id);

    @Delete("delete from student where stu_id = #{stu_id}")
    int deleteStudent(String stu_id);

    @Update("update student set " +
            "name = #{name} ," +
            "gender = #{gender} ," +
            "dept_name = #{dept_name} ," +
            "grade = #{grade} " +
            "where stu_id = #{stu_id}")
    int updateStudent(Student student);
}
