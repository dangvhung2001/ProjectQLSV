package com.dsecurity.service;


import com.dsecurity.service.dto.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);

    Page<StudentDTO> findAll(Pageable pageable);

    Optional<StudentDTO> findOne(Long id);

    void delete(Long id);

    List<StudentDTO> getAll();

}
