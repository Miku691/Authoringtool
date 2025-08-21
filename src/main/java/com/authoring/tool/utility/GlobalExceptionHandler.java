package com.authoring.tool.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class )
	public ResponseEntity<ApiResponse<String>> globalException(Exception ex) {
		ApiResponse<String> apiResponse=new ApiResponse<String>("Failed",ex.getMessage(),500,"Internal Error");
		return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<String>> arugementException(MethodArgumentNotValidException ex) {
		ApiResponse<String> apiResponse=new ApiResponse<String>("Failed",ex.getMessage(),400,"Internal Error");
		return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<String>> resourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponse<String> apiResponse=new ApiResponse<String>("Failed",ex.getMessage(),200,"Value not Available");
		return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
	}

}
