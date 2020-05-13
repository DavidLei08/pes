package com.wang.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StuExam {
    private Integer id;
    private String name;
    private String stu_id;
    private String grade;
    private String gender;
    private String isInput;
}
