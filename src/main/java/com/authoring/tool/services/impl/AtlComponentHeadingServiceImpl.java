package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AtlComponentHeadingDto;
import com.authoring.tool.entity.AtlComponentHeading;
import com.authoring.tool.exception.DetailsNotFoundException;
import com.authoring.tool.repo.AtlComponentHeadingRepo;
import com.authoring.tool.services.AtlComponentHeadingService;

@Service
public class AtlComponentHeadingServiceImpl implements AtlComponentHeadingService{

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private AtlComponentHeadingRepo componentsRepo;
	
	@Override
	public AtlComponentHeadingDto saveComponentHeading(AtlComponentHeadingDto componentHeading) {
		AtlComponentHeading componentSaved =componentsRepo.save(modelMapper.map(componentHeading,AtlComponentHeading.class));
		return modelMapper.map(componentSaved,AtlComponentHeadingDto.class);
	}

	@Override
	public AtlComponentHeadingDto fetchComponentHeading(Long id) {
		AtlComponentHeading componentHeading = componentsRepo.findById(id).orElseThrow(() -> new DetailsNotFoundException("ID", id.toString()));
		return modelMapper.map(componentHeading, AtlComponentHeadingDto.class);
	}

}
