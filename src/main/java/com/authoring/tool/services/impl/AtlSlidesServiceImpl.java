package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AtlSlidesDto;
import com.authoring.tool.entity.AtlSlides;
import com.authoring.tool.exception.DetailsNotFoundException;
import com.authoring.tool.repo.AtlCourseRepo;
import com.authoring.tool.repo.AtlSlidesRepo;
import com.authoring.tool.services.AtlSlidesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtlSlidesServiceImpl implements AtlSlidesService {
	private final AtlSlidesRepo slideRepo;
	private final AtlCourseRepo courseRepo;
	private final ModelMapper modelMapper;
	
	@Override
	public AtlSlidesDto saveSlide(AtlSlidesDto slideDto) {
		courseRepo.findById(slideDto.getCourse().getId()).orElseThrow(() -> new DetailsNotFoundException("Course ID", slideDto.getCourse().getId()+""));
		
		AtlSlides savedSlide = slideRepo.save(modelMapper.map(slideDto, AtlSlides.class));
		return modelMapper.map(savedSlide, AtlSlidesDto.class);
	}

	@Override
	public AtlSlidesDto getSlideById(Long slideId) {
		AtlSlides slideObj = slideRepo.findById(slideId).orElseThrow(() -> new DetailsNotFoundException("slideId", slideId.toString()));
		return modelMapper.map(slideObj, AtlSlidesDto.class);
	}

}
