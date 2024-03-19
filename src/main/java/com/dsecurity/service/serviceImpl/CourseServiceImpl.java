package com.dsecurity.service.serviceImpl;

import com.dsecurity.entity.Courses;
import com.dsecurity.repository.CourseRepository;
import com.dsecurity.service.CourseService;
import com.dsecurity.service.dto.CourseDTO;
import com.dsecurity.service.mapper.CourseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseMapper courseMapper, CourseRepository courseRepository) {
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        Courses course = courseMapper.toEntity(courseDTO);
        Courses savedCourse = courseRepository.save(course);
        return courseMapper.toDto(savedCourse);
    }

    @Override
    public Page<CourseDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<CourseDTO> findOne(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Courses> courseList = courseRepository.findAll();
        return courseList.stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }
}