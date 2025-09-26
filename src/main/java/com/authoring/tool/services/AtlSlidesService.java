package com.authoring.tool.services;

import com.authoring.tool.dto.AtlSlidesDto;

public interface AtlSlidesService {
	AtlSlidesDto saveSlide(AtlSlidesDto slideDto);
	AtlSlidesDto getSlideById(Long slideId);
}
