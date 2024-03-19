package com.dsecurity.service.serviceImpl;

import com.dsecurity.entity.Student;
import com.dsecurity.repository.StudentRepository;
import com.dsecurity.service.StudentService;
import com.dsecurity.service.dto.StudentDTO;
import com.dsecurity.service.mapper.StudentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Page<StudentDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id).map(studentMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}