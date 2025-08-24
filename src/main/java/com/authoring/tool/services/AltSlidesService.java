package com.authoring.tool.services;

import java.util.List;

import com.authoring.tool.dto.AltSlidesDto;
import com.authoring.tool.utility.ResourceNotFoundException;

public interface AltSlidesService {
	
	public AltSlidesDto addSlide(AltSlidesDto altSlidesDto);
	public List<AltSlidesDto> getSlidesByCourse(int id);
	public AltSlidesDto updateSlideInfo(AltSlidesDto altSlidesDto) throws ResourceNotFoundException;
	public String deleteSlidesByCourse(Long id) throws ResourceNotFoundException;

}
