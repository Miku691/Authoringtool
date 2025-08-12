package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.authoring.tool.dto.AtlMediaAssestsDto;
import com.authoring.tool.services.AtlMediaAssestsService;

public class AtlMediaAssestsServiceImpl implements AtlMediaAssestsService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AtlMediaAssestsDto saveMediaAssest(AtlMediaAssestsDto mediaAsset) {
		
		return null;
	}

	@Override
	public AtlMediaAssestsDto fetchMediaAssest(Long id) {
		
		return null;
	}

}
