package com.wang.service.examination;

import com.wang.mapper.ExaminationMapper;
import com.wang.pojo.Examination;
import com.wang.pojo.StuExam;
import com.wang.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationMapper examinationMapper;

    @Autowired
    private StudentService studentService;

    @Override
    public int addExamination(Examination examination) {
        int i = examinationMapper.addExamination(examination);
        int i1 = studentService.updateStudentIsInput(examination.getStu_id());
        return i==i1 ? 1 : 0;
    }

    @Override
    public List<StuExam> queryExaminationList() {
        return examinationMapper.queryExaminationList();
    }


    @Override
    public Examination queryExaminationById(Integer id) {
        return examinationMapper.queryExaminationById(id);
    }

    @Override
    public List<StuExam> isInputList() {
        return examinationMapper.isInputList();
    }

    @Override
    public List<StuExam> noInputList() {
        return examinationMapper.noInputList();
    }

    @Override
    public int deleteExamination(String stu_id) {
       return examinationMapper.deleteExamination(stu_id);
    }

    @Override
    public int updateExamination(Examination examination) {
        return examinationMapper.updateExamination(examination);
    }

    @Override
    public Examination queryExaminationByStu(String stu_id) {
        Examination  examination = examinationMapper.queryExaminationByStu(stu_id);

        return examination;
    }

    @Override
    public int deleteExaminationById(Integer id){
        return examinationMapper.deleteExaminationById(id);
    }

}
