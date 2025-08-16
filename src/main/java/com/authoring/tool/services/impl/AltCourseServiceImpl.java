package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.entity.AltCourseEntity;
import com.authoring.tool.repo.AltCourseRepo;
import com.authoring.tool.services.AltCourseService;

@Service
public class AltCourseServiceImpl implements AltCourseService{
	
	private AltCourseRepo altCourseRepo;
	private ModelMapper modelMapper;

	@Override
	public AltCourseDto createCourse(AltCourseDto altCourseDto) {
		AltCourseEntity altCourseEntity=altCourseRepo.save(modelMapper.map(altCourseDto, AltCourseEntity.class));
		return modelMapper.map(altCourseEntity,AltCourseDto.class);
	
	}
	
	public AltCourseServiceImpl(AltCourseRepo altCourseRepo,ModelMapper modelMapper) {
		this.altCourseRepo=altCourseRepo;
		this.modelMapper=modelMapper;
	}

}
