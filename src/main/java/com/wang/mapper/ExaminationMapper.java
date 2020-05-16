package com.wang.mapper;

import com.wang.pojo.Examination;
import com.wang.pojo.StuExam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExaminationMapper {

    @Insert(value = "insert into examination (id,stu_id,name,height,\n" +
            "weight,nose,noseDiseases,tooth,\n" +
            "stuttering,bloodPressure,heartRate,\n" +
            "liver,eyeLeft,eyeRight,eyeDiseases) \n" +
            "values(null,\n" +
            "#{examination.stu_id},\n" +
            "#{examination.name},\n" +
            "#{examination.height},\n" +
            "#{examination.weight},\n" +
            "#{examination.nose},\n" +
            "#{examination.noseDiseases},\n" +
            "#{examination.tooth},\n" +
            "#{examination.stuttering},\n" +
            "#{examination.bloodPressure},\n" +
            "#{examination.heartRate},\n" +
            "#{examination.liver},\n" +
            "#{examination.eyeLeft},\n" +
            "#{examination.eyeRight},\n" +
            "#{examination.eyeDiseases}\n" +
            ")")
    int addExamination(@Param("examination") Examination examination);

    @Select("select a.stu_id,a.`name`,a.`gender`,a.grade,b.id,a.isInput \n" +
            "from student a \n" +
            "left join examination b \n" +
            "on a.stu_id = b.stu_id ")
    List<StuExam> queryExaminationList();


    @Select("select * from examination where id = #{id}")
    Examination queryExaminationById(Integer id);


    @Select("select * from examination where stu_id = #{stu_id}")
    Examination queryExaminationByStu(String  stu_id);

    @Select("select a.stu_id,a.`name`,a.`gender`,a.grade,b.id,a.isInput \n" +
            "from student a \n" +
            "left join examination b \n" +
            "on a.stu_id = b.stu_id \n" +
            "where a.isInput = 0;")
    List<StuExam> noInputList();

    @Select("select a.stu_id,a.`name`,a.`gender`,a.grade,b.id,a.isInput \n" +
            "from student a \n" +
            "left join examination b \n" +
            "on a.stu_id = b.stu_id \n" +
            "where a.isInput = 1;")
    List<StuExam> isInputList();

    @Delete("delete from examination where stu_id = #{stu_id}")
    int deleteExamination(String stu_id);

    @Delete("delete from examination where id = #{id}")
    int deleteExaminationById(Integer  id);

    @Insert(value = "update examination set\n" +
            "stu_id=#{examination.stu_id},\n" +
            "name=#{examination.name},\n" +
            "height=#{examination.height},\n" +
            "weight=#{examination.weight},\n" +
            "nose=#{examination.nose},\n" +
            "noseDiseases=#{examination.noseDiseases},\n" +
            "tooth=#{examination.tooth},\n" +
            "stuttering=#{examination.stuttering},\n" +
            "bloodPressure=#{examination.bloodPressure},\n" +
            "heartRate=#{examination.heartRate},\n" +
            "liver=#{examination.liver},\n" +
            "eyeLeft=#{examination.eyeLeft},\n" +
            "eyeRight=#{examination.eyeRight},\n" +
            "eyeDiseases=#{examination.eyeDiseases}\n" +
            "where id =#{examination.id}")
    int updateExamination(@Param("examination") Examination examination);
}
