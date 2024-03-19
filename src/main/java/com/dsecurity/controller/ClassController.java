package com.dsecurity.controller;

import com.dsecurity.service.ClassService;
import com.dsecurity.service.dto.ClassDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
    @RequestMapping("/api/classes")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<ClassDTO> createClass(@Valid @RequestBody ClassDTO classDTO) {
        ClassDTO createdClass = classService.save(classDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClass);
    }

    @GetMapping
    public ResponseEntity<List<ClassDTO>> getAllClasses() {
        List<ClassDTO> classList = classService.getAll();
        return ResponseEntity.ok(classList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDTO> getClassById(@PathVariable Long id) {
        return classService.findOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDTO> updateClass(@PathVariable Long id, @Valid @RequestBody ClassDTO classDTO) {
        return classService.findOne(id)
                .map(existingClass -> {
                    classDTO.setId(id);
                    ClassDTO updatedClass = classService.save(classDTO);
                    return ResponseEntity.ok(updatedClass);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

