package com.wang.service.examination;

import com.wang.pojo.Examination;
import com.wang.pojo.StuExam;

import java.util.List;

public interface ExaminationService {
    int addExamination(Examination examination);

    List<StuExam> queryExaminationList();

    Examination queryExaminationById(Integer id);

    List<StuExam> isInputList();

    List<StuExam> noInputList();

    int deleteExamination(String stu_id);

    int deleteExaminationById(Integer id);

    int updateExamination(Examination examination);

    Examination queryExaminationByStu(String stu_id);
}
