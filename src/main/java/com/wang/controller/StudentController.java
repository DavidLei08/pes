package com.wang.controller;

import com.wang.pojo.Student;
import com.wang.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/add")
    public String addStudent(){
        return "student/student_add";
    }

    @RequestMapping("/student/add/deal")
    @ResponseBody
    public HashMap addStudentDeal(@RequestBody Student student){
        HashMap<String, String> map = new HashMap<>();
        student.setIsInput(0);
        int i = studentService.addStudent(student);
        if (i==1){
            map.put("msg","添加成功");
        }else{
            map.put("msg","添加失败");
        }

        return map;
    }

    /**
     * 逻辑删除
     * @param stu_id
     * @return
     */
    @RequestMapping("/student/delete/{stu_id}")
    @ResponseBody
    public HashMap deleteStudent(@PathVariable String stu_id){
        HashMap<String, String> map = new HashMap<String,String>();
        int i = studentService.deleteStudent(stu_id);
        if(i==1){
            map.put("msg","删除成功");
        }else{
            map.put("msg","删除失败");
        }
        return map;
    }


    @RequestMapping("/student/list")
    public String studentList(Model model){
        List<Student> students = studentService.queryStudentList();
        model.addAttribute("students",students);
        return "student/student-list";
    }
}
