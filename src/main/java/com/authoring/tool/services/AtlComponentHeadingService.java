package com.authoring.tool.services;

import com.authoring.tool.dto.AtlComponentHeadingDto;
import com.authoring.tool.entity.AtlComponentHeading;

public interface AtlComponentHeadingService {
	AtlComponentHeadingDto saveComponentHeading(AtlComponentHeadingDto headingDto);
	AtlComponentHeadingDto getComponentHeading(Long headingId);
}