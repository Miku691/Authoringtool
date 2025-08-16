package com.authoring.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.services.AltCourseService;
import com.authoring.tool.utility.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class AltCourseController {
	
	private AltCourseService altCourseService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<AltCourseDto>> createCourse(@Valid @RequestBody AltCourseDto altCourseDto) {
		ApiResponse<AltCourseDto> apiResponse=new ApiResponse<AltCourseDto>("Success","Created Successfully",200,altCourseService.createCourse(altCourseDto));
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED) ;
	}
	
	public AltCourseController(AltCourseService altCourseService) {
		this.altCourseService=altCourseService;
		
	}

	
}
