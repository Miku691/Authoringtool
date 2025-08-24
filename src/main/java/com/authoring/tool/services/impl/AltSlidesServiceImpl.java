package com.authoring.tool.services.impl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AltSlidesDto;
import com.authoring.tool.entity.AltSlidesEntity;
import com.authoring.tool.repo.AltSlidesRepo;
import com.authoring.tool.services.AltSlidesService;
import com.authoring.tool.utility.ResourceNotFoundException;

@Service
public class AltSlidesServiceImpl implements AltSlidesService{
	
	private ModelMapper modelMapper;
	private AltSlidesRepo altSlidesRepo;

	public AltSlidesDto addSlide(AltSlidesDto altSlidesDto) {
		AltSlidesEntity altSlidesEntity=new AltSlidesEntity();
		modelMapper.map(altSlidesDto,altSlidesEntity);
		AltSlidesEntity resultEntity=altSlidesRepo.save(altSlidesEntity);
		return modelMapper.map(resultEntity,AltSlidesDto.class);
		
	}
	
	public List<AltSlidesDto> getSlidesByCourse(int id){
		List <AltSlidesEntity> result=altSlidesRepo.findbyCourse_id(id);
		return result.stream().map(obj->modelMapper.map(result, AltSlidesDto.class)).collect(Collectors.toList());
		
	}
	
	public AltSlidesDto updateSlideInfo(AltSlidesDto altSlidesDto) throws ResourceNotFoundException {
		AltSlidesEntity altSlidesEntity=altSlidesRepo.findById(altSlidesDto.getId()).orElseThrow(()->new ResolutionException("Id not available to update"));
		modelMapper.map(altSlidesDto,altSlidesEntity);
		AltSlidesEntity Entity=altSlidesRepo.save(altSlidesEntity);
		return modelMapper.map(Entity, AltSlidesDto.class);
	}
	
	public String deleteSlidesByCourse(Long id) throws ResourceNotFoundException {
		AltSlidesEntity altSlidesEntity=altSlidesRepo.findById(id).orElseThrow(()->new ResolutionException("Id not available to update"));
		altSlidesRepo.delete(altSlidesEntity);
		return "Detleted";
	}
	
	public AltSlidesServiceImpl(ModelMapper modelMapper,AltSlidesRepo altSlidesRepo) {
		
		this.modelMapper=modelMapper;
		this.altSlidesRepo=altSlidesRepo;
		
	}

	

	
}
