package com.authoring.tool.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AtlMediaAssestsDto;
import com.authoring.tool.entity.AtlMediaAssests;
import com.authoring.tool.exception.DetailsNotFoundException;
import com.authoring.tool.repo.AtlMediaAssestsRepo;
import com.authoring.tool.services.AtlMediaAssestsService;

@Service
public class AtlMediaAssestsServiceImpl implements AtlMediaAssestsService{

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private AtlMediaAssestsRepo assestsRepo;
	
	@Override
	public AtlMediaAssestsDto saveMediaAssest(AtlMediaAssestsDto mediaAsset) {
		AtlMediaAssests mediaAssetSaved = assestsRepo.save(modelMapper.map(mediaAsset, AtlMediaAssests.class));
		return modelMapper.map(mediaAssetSaved, AtlMediaAssestsDto.class);
	}

	@Override
	public AtlMediaAssestsDto fetchMediaAssest(Long id) {
		AtlMediaAssests mediaAsset = assestsRepo.findById(id).orElseThrow(() -> new DetailsNotFoundException("ID", id.toString()));
		return modelMapper.map(mediaAsset, AtlMediaAssestsDto.class);
	}

}
