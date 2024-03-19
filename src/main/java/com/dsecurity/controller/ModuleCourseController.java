package com.dsecurity.controller;

import com.dsecurity.service.ModuleCourseService;
import com.dsecurity.service.dto.ModuleCourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/moduleCourses")
public class ModuleCourseController {
    private final ModuleCourseService moduleCourseService;

    public ModuleCourseController(ModuleCourseService moduleCourseService) {
        this.moduleCourseService = moduleCourseService;
    }

    @PostMapping
    public ResponseEntity<ModuleCourseDTO> createModuleCourse(@Valid @RequestBody ModuleCourseDTO moduleCourseDTO) {
        if (moduleCourseDTO.getId() != null) {
            System.out.println("not found");
        }
        ModuleCourseDTO createdModuleCourse = moduleCourseService.save(moduleCourseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModuleCourse);
    }

    @GetMapping
    public ResponseEntity<List<ModuleCourseDTO>> getAllModuleCourses() {
        List<ModuleCourseDTO> moduleCourseList = moduleCourseService.getAll();
        return ResponseEntity.ok(moduleCourseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleCourseDTO> getModuleCourseById(@PathVariable Long id) {
        return moduleCourseService.findOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleCourseDTO> updateModuleCourse(@PathVariable Long id, @Valid @RequestBody ModuleCourseDTO moduleCourseDTO) {
        return moduleCourseService.findOne(id)
                .map(existingModuleCourse -> {
                    moduleCourseDTO.setId(id);
                    ModuleCourseDTO updatedModuleCourse = moduleCourseService.save(moduleCourseDTO);
                    return ResponseEntity.ok(updatedModuleCourse);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModuleCourse(@PathVariable Long id) {
        moduleCourseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
