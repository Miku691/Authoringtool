package com.authoring.tool.services;

import com.authoring.tool.dto.AtlComponentHeadingDto;

public interface AtlComponentHeadingService {
	
	AtlComponentHeadingDto saveComponentHeading(AtlComponentHeadingDto componentHeading);
	AtlComponentHeadingDto fetchComponentHeading(Long id);

}
