package com.dsecurity.service;

import com.dsecurity.service.dto.ModuleCourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ModuleCourseService {
    ModuleCourseDTO save(ModuleCourseDTO moduleCourseDTO);

    Page<ModuleCourseDTO> findAll(Pageable pageable);

    Optional<ModuleCourseDTO> findOne(Long id);

    void delete(Long id);

    List<ModuleCourseDTO> getAll();
}
