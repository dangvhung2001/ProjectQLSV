package com.dsecurity.service;

import com.dsecurity.service.dto.ClassDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    ClassDTO save(ClassDTO classDTO);

    Page<ClassDTO> findAll(Pageable pageable);

    Optional<ClassDTO> findOne(Long id);

    void delete(Long id);

    List<ClassDTO> getAll();
}
