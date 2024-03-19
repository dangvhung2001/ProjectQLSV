package com.dsecurity.service.mapper.mapperImpl;

import com.dsecurity.entity.Class;
import com.dsecurity.service.dto.ClassDTO;
import com.dsecurity.service.mapper.ClassMapper;
import com.dsecurity.service.mapper.CourseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassMapperImpl implements ClassMapper {

    private final CourseMapper courseMapper;

    public ClassMapperImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public Class toEntity(ClassDTO dto) {
        if (dto == null) {
            return null;
        }
        Class entity = new Class();
        entity.setId(dto.getId());
        entity.setClassName(dto.getClassName());

        entity.setStartTime(dto.getStartTime());
        entity.setCourse(courseMapper.toEntity(dto.getCourse()));
        return entity;
    }

    @Override
    public ClassDTO toDto(Class entity) {
        if (entity == null) {
            return null;
        }

        ClassDTO dto = new ClassDTO();
        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setStartTime(entity.getStartTime());
        dto.setCourse(courseMapper.toDto(entity.getCourse()));
        return dto;
    }

    @Override
    public List<Class> toEntity(List<ClassDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Class> entityList = new ArrayList<>();
        for (ClassDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<ClassDTO> toDto(List<Class> entityList) {
        if (entityList == null) {
            return null;
        }
        List<ClassDTO> dtoList = new ArrayList<>();
        for (Class entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
