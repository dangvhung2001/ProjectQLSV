package com.dsecurity.service.mapper.mapperImpl;

import com.dsecurity.entity.Student;
import com.dsecurity.service.dto.StudentDTO;
import com.dsecurity.service.mapper.ClassMapper;
import com.dsecurity.service.mapper.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {

    private final ClassMapper classMapper;

    public StudentMapperImpl(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        if (dto == null) {
            return null;
        }

        Student student = new Student();
        student.setId(dto.getId());
        student.setEmail(dto.getEmail());
        student.setFullName(dto.getFullName());

        student.setBirthday(dto.getBirthday());
        student.setPhone(dto.getPhone());
        student.setAddress(dto.getAddress());
        student.setCreatedAt(dto.getCreatedAt());
        student.setUpdatedAt(dto.getUpdatedAt());
        student.setAClass(classMapper.toEntity(dto.getClassDTO()));

        return student;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        if (entity == null) {
            return null;
        }

        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());

        dto.setBirthday(entity.getBirthday());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setClassDTO(classMapper.toDto(entity.getAClass()));

        return dto;
    }

    @Override
    public List<Student> toEntity(List<StudentDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Student> entityList = new ArrayList<>();
        for (StudentDTO dto : dtoList) {
            entityList.add(toEntity(dto));
        }
        return entityList;
    }

    @Override
    public List<StudentDTO> toDto(List<Student> entityList) {
        if (entityList == null) {
            return null;
        }
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }
}
