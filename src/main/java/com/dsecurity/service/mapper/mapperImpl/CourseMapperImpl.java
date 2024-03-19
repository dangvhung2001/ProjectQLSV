package com.dsecurity.service.mapper.mapperImpl;

import com.dsecurity.entity.Courses;
import com.dsecurity.service.dto.CourseDTO;
import com.dsecurity.service.mapper.CourseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CourseMapperImpl implements CourseMapper {
    @Override
    public Courses toEntity(CourseDTO dto) {
        if (dto == null) {
            return null;
        }

        Courses course = new Courses();
        course.setId(dto.getId());
        course.setCourseName(dto.getCourseName());
        course.setCourseTime(dto.getCourseTime());

        return course;
    }

    @Override
    public CourseDTO toDto(Courses entity) {
        if (entity == null) {
            return null;
        }

        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setCourseName(entity.getCourseName());
        dto.setCourseTime(entity.getCourseTime());

        return dto;
    }

    @Override
    public List<Courses> toEntity(List<CourseDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Courses> entityList = new ArrayList<>();
        for (CourseDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<CourseDTO> toDto(List<Courses> entityList) {
        if (entityList == null) {
            return null;
        }
        List<CourseDTO> dtoList = new ArrayList<>();
        for (Courses entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
