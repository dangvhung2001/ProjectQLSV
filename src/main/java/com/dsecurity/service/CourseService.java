package com.dsecurity.service;

import com.dsecurity.service.dto.CourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDTO save(CourseDTO courseDTO);

    Page<CourseDTO> findAll(Pageable pageable);

    Optional<CourseDTO> findOne(Long id);

    void delete(Long id);

    List<CourseDTO> getAll();
}
