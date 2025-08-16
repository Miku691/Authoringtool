package com.authoring.tool.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authoring.tool.entity.AltCourseEntity;

@Repository
public interface AltCourseRepo extends JpaRepository<AltCourseEntity, Long>{

}
