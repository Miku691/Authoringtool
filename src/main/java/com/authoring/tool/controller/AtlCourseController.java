package com.authoring.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authoring.tool.dto.AtlCourseDto;
import com.authoring.tool.services.AtlCourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class AtlCourseController {
	private final AtlCourseService courseService;
	
	@PostMapping
	public ResponseEntity<AtlCourseDto> saveCourseDetails(@RequestBody AtlCourseDto courseDto){
		return new ResponseEntity<AtlCourseDto>(courseService.saveAtlCourse(courseDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<AtlCourseDto> getCourseById(@RequestParam("courseId") Long courseId){
		return new ResponseEntity<AtlCourseDto>(courseService.getAtlCouseById(courseId), HttpStatus.OK);
	}
}
