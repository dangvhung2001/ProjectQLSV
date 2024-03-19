package com.dsecurity.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class ClassDTO {
    private Long id;
    private String className;
    private boolean status;
    private Date startTime;
    private Long courseId;
    private CourseDTO course;

    public ClassDTO() {
    }
}
