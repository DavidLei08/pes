package com.wang.controller;

import com.wang.pojo.Examination;
import com.wang.pojo.StuExam;
import com.wang.pojo.User;
import com.wang.service.examination.ExaminationService;
import com.wang.service.student.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/examination/list")
    public String exmainationList(Model model){
        List<StuExam> examinationList = examinationService.queryExaminationList();
        model.addAttribute("examinationList",examinationList);
        return "examination/list";
    }

    @RequestMapping("/examination/add")
    public String addExamination(HttpSession httpSession, Model model){

        String username = (String) httpSession.getAttribute("username");


        model.addAttribute("stu_id",username);
        return "examination/examination-add";
    }

    @RequestMapping("/examination/add/deal")
    @ResponseBody
    public HashMap addExaminationDeal(@RequestBody Examination examination){
        HashMap<String, String> map = new HashMap<>();
        int i = examinationService.addExamination(examination);

        if (i==1){
            map.put("msg","录入成功");
        }else{
            map.put("msg","录入失败");
        }
        return map;
    }

    @RequestMapping("/examination/isInput")
    public String IsInput(Model model){
        List<StuExam> isInputList = examinationService.isInputList();
        model.addAttribute("isInput",isInputList);
        return "examination/isInput-list";
    }

    @RequestMapping("/examination/noInput")
    public String NoInput(Model model){
        List<StuExam> noInputList = examinationService.noInputList();
        model.addAttribute("noInput",noInputList);
        return "examination/noInput-list";
    }

    @RequestMapping("/examination/update/{id}")
    public String updateExamination(@PathVariable("id") Integer id, Model model){
        Examination examination = examinationService.queryExaminationById(id);
        model.addAttribute("examination",examination);
        return "examination/update";
    }

    @RequestMapping("/examination/update/deal")
    @ResponseBody
    public HashMap updateExamination(@RequestBody Examination examination){
        HashMap<String, String> map = new HashMap<>();

        int i = examinationService.updateExamination(examination);
        if (i==1){
            map.put("msg","更新成功");
        }else{
            map.put("msg","更新失败");
        }
        return map;
    }


    @RequestMapping("/examination/delete/{id}")
    @ResponseBody
    public HashMap delExamination(@PathVariable("id") Integer id){
        HashMap<String, String> map = new HashMap<>();

        int i = examinationService.deleteExaminationById(id);
        if (i==1){
            map.put("msg","删除成功");
        }else{
            map.put("msg","删除失败");
        }
        return map;
    }

    @GetMapping("/examination/personInfo")
    public String  examinationPersonInfo(Model model){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String userName = (String)session.getAttribute("username");

        Examination examination = examinationService.queryExaminationByStu(userName);
        if(examination == null) {
            examination = new Examination();
        }
        model.addAttribute("examination",examination);
        return "/examination/personInfo";
    }
}
