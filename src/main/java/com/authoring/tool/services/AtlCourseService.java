package com.authoring.tool.services;

import com.authoring.tool.dto.AtlCourseDto;

public interface AtlCourseService {
	AtlCourseDto saveAtlCourse(AtlCourseDto course);
	AtlCourseDto getAtlCouseById(Long courseId);
}
