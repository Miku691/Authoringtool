package com.authoring.tool.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.utility.ResourceNotFoundException;

public interface AltCourseService {
	
	public AltCourseDto createCourse(AltCourseDto altCourseDto);
	public List<AltCourseDto> getAllCourseDtls();
	public Optional<AltCourseDto> getCourseDtls(Long id) throws ResourceNotFoundException;
	public AltCourseDto updateById(Long id,AltCourseDto altCourseDto) throws ResourceNotFoundException ;
	public void deleteCourse(Long id) throws ResourceNotFoundException;
	public  Page<AltCourseDto>  getCourseDtlsByPage(Pageable pageable);

}
