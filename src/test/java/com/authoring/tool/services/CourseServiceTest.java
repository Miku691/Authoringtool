package com.authoring.tool.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.entity.AltCourseEntity;
import com.authoring.tool.repo.AltCourseRepo;
import com.authoring.tool.services.impl.AltCourseServiceImpl;

public class CourseServiceTest {
	
	@Mock
	private  AltCourseRepo altCourseRepo;
	@Mock
	private ModelMapper modelMapper;
	@InjectMocks
	private AltCourseServiceImpl altCourseServiceImpl;
	
	private AltCourseDto altCourseDto;
	private AltCourseEntity altCourseEntity;
	
	@BeforeEach
	void init() {
	MockitoAnnotations.openMocks(this);
	
	altCourseDto=new AltCourseDto();
	altCourseDto.setAuthor("Kingsly");
	altCourseDto.setCreatedOn(LocalDate.now());
	altCourseDto.setDesc("Summa");
	altCourseDto.setTitle("Test");
	
	

	altCourseEntity = new AltCourseEntity();
	altCourseEntity.setTitle("Test");
	altCourseEntity.setDesc("Summa");
	altCourseEntity.setAuthor("Kingsly");
	altCourseEntity.setCreatedOn(LocalDate.now());
	
	}
	
	@Test
	void createCourse() {
		
		when(modelMapper.map(altCourseDto, AltCourseEntity.class)).thenReturn(altCourseEntity);
		when(modelMapper.map(altCourseEntity,AltCourseDto.class)).thenReturn(altCourseDto);
		when(altCourseRepo.save(altCourseEntity)).thenReturn(altCourseEntity);
		
	
		
		
		AltCourseDto result=altCourseServiceImpl.createCourse(altCourseDto);
		
		assertNotNull(result);
		assertEquals("Kingsly", result.getAuthor());
		
		//verify(modelMapper,times(0)).map(altCourseDto, AltCourseEntity.class);
	
	}

}
