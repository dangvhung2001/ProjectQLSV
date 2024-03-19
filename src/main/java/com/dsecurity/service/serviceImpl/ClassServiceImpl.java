package com.dsecurity.service.serviceImpl;

import com.dsecurity.entity.Class;
import com.dsecurity.repository.ClassRepository;
import com.dsecurity.service.ClassService;
import com.dsecurity.service.dto.ClassDTO;
import com.dsecurity.service.mapper.ClassMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassMapper classMapper;
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassMapper classMapper, ClassRepository classRepository) {
        this.classMapper = classMapper;
        this.classRepository = classRepository;
    }

    @Override
    public ClassDTO save(ClassDTO classDTO) {
        Class classEntity = classMapper.toEntity(classDTO);
        Class savedClass = classRepository.save(classEntity);
        return classMapper.toDto(savedClass);
    }

    @Override
    public Page<ClassDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ClassDTO> findOne(Long id) {
        return classRepository.findById(id).map(classMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        classRepository.deleteById(id);

    }

    @Override
    public List<ClassDTO> getAll() {
        List<Class> classList = classRepository.findAll();
        return classList.stream()
                .map(classMapper::toDto)
                .collect(Collectors.toList());
    }
}
