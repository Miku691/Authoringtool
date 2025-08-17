package com.authoring.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authoring.tool.dto.AtlComponentHeadingDto;
import com.authoring.tool.services.AtlComponentHeadingService;

@RestController
@RequestMapping("component-heading")
public class AtlComponentHeadingController {

	@Autowired
	private AtlComponentHeadingService componentService;
	
	@PostMapping
	public ResponseEntity<AtlComponentHeadingDto> saveComponent(@RequestBody AtlComponentHeadingDto componentDto)
	{
		return new ResponseEntity<AtlComponentHeadingDto>(componentService.saveComponentHeading(componentDto),HttpStatus.CREATED);
	}
}
