package com.wang.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String stu_id;
    private String name;
    private String gender;
    private Integer dept_name;
    private String grade;
    private Integer isInput;
}
