package com.authoring.tool.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.services.AltCourseService;
import com.authoring.tool.utility.ApiResponse;
import com.authoring.tool.utility.ResourceNotFoundException;

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
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<AltCourseDto>>> getAllCourseDtls(){
		ApiResponse<List<AltCourseDto> >apiResponse= new ApiResponse<List<AltCourseDto>>("Success","Details Fetched Successfully",200,altCourseService.getAllCourseDtls());
		return new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<AltCourseDto>> getCourseDtls(@PathVariable Long id) throws ResourceNotFoundException{
		AltCourseDto altCourseDto=altCourseService.getCourseDtls(id).orElseThrow(()->new ResourceNotFoundException("Course not found with id: " + id));
		ApiResponse<AltCourseDto> apiResponse=new ApiResponse<AltCourseDto>("Success", "Details fetched successfully", 200,altCourseDto);
		return new ResponseEntity<>(apiResponse,HttpStatus.ACCEPTED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<AltCourseDto>> updateById(@PathVariable Long id, @RequestBody AltCourseDto altCourseDto) throws ResourceNotFoundException{
		ApiResponse<AltCourseDto> apiResponse=new ApiResponse<AltCourseDto>( "Success", "Details Updated successfully", 200,altCourseService.updateById(id,altCourseDto));
		return new ResponseEntity<ApiResponse<AltCourseDto>>(apiResponse,HttpStatus.OK);
	}
	@DeleteMapping("/{id}") 
	public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable Long id) throws ResourceNotFoundException{
		altCourseService.deleteCourse(id);
		ApiResponse<Void> apiResponse=new ApiResponse<Void>( "Success", "Details Deleted successfully", 200,null);
		return new ResponseEntity<ApiResponse<Void>>(apiResponse,HttpStatus.OK);
	}
	@GetMapping("/page")
	public ResponseEntity<ApiResponse<Page<AltCourseDto>>> getDtlsByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5")int size,@RequestParam(defaultValue = "id") String searchBy){
		Pageable pageable=PageRequest.of(page, size, Sort.by(searchBy));
		Page<AltCourseDto> coursePage = altCourseService.getCourseDtlsByPage(pageable);
		ApiResponse<Page<AltCourseDto>> apiResponse = new ApiResponse<>( "Success","Details Fetched successfully", 200, coursePage);
	    return new ResponseEntity<ApiResponse<Page<AltCourseDto>>>(apiResponse,HttpStatus.OK);
	
	}
	public AltCourseController(AltCourseService altCourseService) {
		this.altCourseService=altCourseService;
		
	}

	
}
