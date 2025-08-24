package com.authoring.tool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authoring.tool.dto.AltSlidesDto;
import com.authoring.tool.services.AltSlidesService;
import com.authoring.tool.utility.ApiResponse;
import com.authoring.tool.utility.ResourceNotFoundException;

@RestController
@RequestMapping("/slides")
public class AltSlidesController {
	
	private AltSlidesService altSlidesService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<AltSlidesDto>> addSlide(@RequestBody AltSlidesDto altSlidesDto) {
		ApiResponse<AltSlidesDto> response=new ApiResponse<AltSlidesDto>("Success","Added Successfull",200,altSlidesService.addSlide(altSlidesDto));
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<ApiResponse<List<AltSlidesDto>>> getSlidesByCourse(@RequestParam (value="CouresId") int id){
		ApiResponse<List<AltSlidesDto>> response=new ApiResponse<List<AltSlidesDto>>("Success","Added Successfull",200,	altSlidesService.getSlidesByCourse(id));
		return new ResponseEntity<ApiResponse<List<AltSlidesDto>>>(	response,HttpStatus.FOUND);
	}
	@PutMapping
	public ResponseEntity<ApiResponse<AltSlidesDto>> updateSlideInfo(@RequestBody AltSlidesDto altSlidesDto) throws ResourceNotFoundException{
		ApiResponse<AltSlidesDto> response=new ApiResponse<AltSlidesDto>("Success","Updated Successfull",200,altSlidesService.updateSlideInfo(altSlidesDto));
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	@DeleteMapping
	public ResponseEntity<ApiResponse<String>> deleteSlidesByCourse(@RequestParam (value="CouresId") Long id) throws ResourceNotFoundException {
		ApiResponse<String> response=new ApiResponse<String>("Success","Deleted Successfull",200,	altSlidesService.deleteSlidesByCourse(id));
		return new ResponseEntity<ApiResponse<String>>(response,HttpStatus.ACCEPTED);
	}
	

	public AltSlidesController(AltSlidesService altSlidesService) {
		this.altSlidesService=altSlidesService;
	}
}
