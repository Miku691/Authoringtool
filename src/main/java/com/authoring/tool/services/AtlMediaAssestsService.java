package com.authoring.tool.services;

import com.authoring.tool.dto.AtlMediaAssestsDto;

public interface AtlMediaAssestsService {
	AtlMediaAssestsDto saveMediaAssest(AtlMediaAssestsDto mediaAsset, Long slideId);
	AtlMediaAssestsDto fetchMediaAssest(Long id);
}