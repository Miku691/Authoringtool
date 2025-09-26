package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AtlCourseDto;
import com.authoring.tool.entity.AtlCourse;
import com.authoring.tool.exception.DetailsNotFoundException;
import com.authoring.tool.repo.AtlCourseRepo;
import com.authoring.tool.services.AtlCourseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AtlCourseServiceImpl implements AtlCourseService {

	private final ModelMapper modelMapper;
	private final AtlCourseRepo courseRepo;
	
	@Override
	public AtlCourseDto saveAtlCourse(AtlCourseDto course) {
		AtlCourse savedCourse = courseRepo.save(modelMapper.map(course, AtlCourse.class));
		return modelMapper.map(savedCourse, AtlCourseDto.class);
	}

	@Override
	public AtlCourseDto getAtlCouseById(Long courseId) {
		AtlCourse courseObj = courseRepo.findById(courseId).orElseThrow(() -> new DetailsNotFoundException("courseId", courseId.toString()));
		return modelMapper.map(courseObj, AtlCourseDto.class);
	}

}
