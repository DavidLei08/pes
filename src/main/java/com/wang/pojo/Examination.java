package com.wang.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Examination {
    private Integer id;
    private String stu_id;
    private String name;
    private String height;
    private String weight;
    private String nose;
    private String noseDiseases;
    private String tooth;
    private String stuttering;
    private String bloodPressure;
    private String heartRate;
    private String liver;
    private String eyeLeft;
    private String eyeRight;
    private String eyeDiseases;
}
