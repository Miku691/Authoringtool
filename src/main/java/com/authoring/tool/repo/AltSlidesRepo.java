package com.authoring.tool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authoring.tool.entity.AltSlidesEntity;

public interface AltSlidesRepo extends JpaRepository<AltSlidesEntity,Long>{
	
	List<AltSlidesEntity> findbyCourse_id(int courseId);

}
