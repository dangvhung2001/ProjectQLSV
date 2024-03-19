package com.dsecurity.repository;


import com.dsecurity.entity.ModuleCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ModuleCourseRepository extends JpaRepository<ModuleCourse, Long> {
}
