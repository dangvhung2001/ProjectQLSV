package com.dsecurity.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String courseName;
    private int courseTime;

    public CourseDTO(Long id, String courseName, int courseTime) {
        this.id = id;
        this.courseName = courseName;
        this.courseTime = courseTime;
    }

    public CourseDTO() {
    }

}

