package com.dsecurity.service.mapper.mapperImpl;

import com.dsecurity.entity.ModuleCourse;
import com.dsecurity.service.dto.ModuleCourseDTO;
import com.dsecurity.service.mapper.CourseMapper;
import com.dsecurity.service.mapper.ModuleCourseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModuleCourseMapperImpl implements ModuleCourseMapper {
    private final CourseMapper courseMapper;

    public ModuleCourseMapperImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public ModuleCourse toEntity(ModuleCourseDTO dto) {
        if (dto == null) {
            return null;
        }

        ModuleCourse entity = new ModuleCourse();
        entity.setId(dto.getId());
        entity.setModuleName(dto.getModuleName());
        entity.setTime(dto.getTime());
        entity.setCourse(courseMapper.toEntity(dto.getCourseDTO()));
        return entity;
    }

    @Override
    public ModuleCourseDTO toDto(ModuleCourse entity) {
        if (entity == null) {
            return null;
        }
        ModuleCourseDTO dto = new ModuleCourseDTO();
        dto.setId(entity.getId());
        dto.setModuleName(entity.getModuleName());
        dto.setTime(entity.getTime());
        dto.setCourseDTO(courseMapper.toDto(entity.getCourse()));
        return dto;
    }

    @Override
    public List<ModuleCourse> toEntity(List<ModuleCourseDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<ModuleCourse> entityList = new ArrayList<>();
        for (ModuleCourseDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<ModuleCourseDTO> toDto(List<ModuleCourse> entityList) {
        if (entityList == null) {
            return null;
        }
        List<ModuleCourseDTO> dtoList = new ArrayList<>();
        for (ModuleCourse entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
