package com.dsecurity.service.serviceImpl;


import com.dsecurity.entity.ModuleCourse;
import com.dsecurity.repository.ModuleCourseRepository;
import com.dsecurity.service.ModuleCourseService;
import com.dsecurity.service.dto.ModuleCourseDTO;
import com.dsecurity.service.mapper.ModuleCourseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleCourseServiceImpl implements ModuleCourseService {

    private final Logger log = LoggerFactory.getLogger(ModuleCourseServiceImpl.class);
    private final ModuleCourseMapper moduleCourseMapper;
    private final ModuleCourseRepository moduleCourseRepository;

    public ModuleCourseServiceImpl(ModuleCourseMapper moduleCourseMapper, ModuleCourseRepository moduleCourseRepository) {
        this.moduleCourseMapper = moduleCourseMapper;
        this.moduleCourseRepository = moduleCourseRepository;
    }

    @Override
    public ModuleCourseDTO save(ModuleCourseDTO moduleCourseDTO) {
        log.debug("Request to save ModuleCourse : {}", moduleCourseDTO);
        ModuleCourse moduleCourse = moduleCourseMapper.toEntity(moduleCourseDTO);
        moduleCourse = moduleCourseRepository.save(moduleCourse);
        return moduleCourseMapper.toDto(moduleCourse);
    }

    @Override
    public Page<ModuleCourseDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ModuleCourseDTO> getAll() {
        List<ModuleCourse> moduleCourseList = moduleCourseRepository.findAll();
        return moduleCourseList.stream()
                .map(moduleCourseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ModuleCourseDTO> findOne(Long id) {
        return moduleCourseRepository.findById(id).map(moduleCourseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        moduleCourseRepository.deleteById(id);
    }
}
