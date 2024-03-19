package com.dsecurity.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleCourseDTO {
    private Long id;
    private String moduleName;
    private int time;
    private Long courseId;
    private String courseName;
    private CourseDTO courseDTO;

    public ModuleCourseDTO() {
    }

    public ModuleCourseDTO(Long id, String moduleName, int time, Long courseId, String courseName) {
        this.id = id;
        this.moduleName = moduleName;
        this.time = time;
        this.courseId = courseId;
        this.courseName = courseName;
    }
}
