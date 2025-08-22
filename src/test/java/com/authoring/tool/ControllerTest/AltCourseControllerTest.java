package com.authoring.tool.ControllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.authoring.tool.controller.AltCourseController;
import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.services.AltCourseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AltCourseController.class)
public class AltCourseControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private AltCourseService altCourseService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testCreateCourse() throws Exception {
		AltCourseDto altCourseDto = new AltCourseDto("Painting","Course for beginners","u",LocalDate.now());
 		when(altCourseService.createCourse(any(AltCourseDto.class))).thenReturn(altCourseDto);
 		
 		mockMvc.perform(post("/course")
 		.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(altCourseDto))).andExpect(status().isCreated());
	}
	
	
	
}
