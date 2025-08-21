package com.authoring.tool.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.authoring.tool.dto.AltCourseDto;
import com.authoring.tool.entity.AltCourseEntity;
import com.authoring.tool.repo.AltCourseRepo;
import com.authoring.tool.services.AltCourseService;
import com.authoring.tool.utility.ResourceNotFoundException;

@Service
public class AltCourseServiceImpl implements AltCourseService{
	
	private AltCourseRepo altCourseRepo;
	private ModelMapper modelMapper;

	@Override
	public AltCourseDto createCourse(AltCourseDto altCourseDto) {
		AltCourseEntity altCourseEntity=altCourseRepo.save(modelMapper.map(altCourseDto, AltCourseEntity.class));
		return modelMapper.map(altCourseEntity,AltCourseDto.class);
	
	}
	public List<AltCourseDto> getAllCourseDtls() {
		return altCourseRepo.findAll().stream().map(entity-> modelMapper.map(entity,AltCourseDto.class)).collect(Collectors.toList());
	}
	
	public Optional<AltCourseDto> getCourseDtls(Long id) throws ResourceNotFoundException {
		
		return altCourseRepo.findById(id).map(ent->modelMapper.map(ent,AltCourseDto.class));
	}
	@Override
	public AltCourseDto updateById(Long id,AltCourseDto altCourseDto) throws ResourceNotFoundException {
		AltCourseEntity altCourseEntity=altCourseRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("ID not available to Update"));
		modelMapper.map(altCourseDto,altCourseEntity);
		AltCourseEntity updateEntity= altCourseRepo.save(altCourseEntity);
		 return modelMapper.map(updateEntity,AltCourseDto.class);
	}
	@Override
	public void deleteCourse(Long id) throws ResourceNotFoundException {
		AltCourseEntity altCourseEntity=altCourseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found to delete"));
		altCourseRepo.delete(altCourseEntity);
		
	}
	@Override
	public Page<AltCourseDto> getCourseDtlsByPage(Pageable pageable) {
		Page courses =altCourseRepo.findAll(pageable);
		return courses.map(course->modelMapper.map(course, AltCourseDto.class));
	}	
	
	public AltCourseServiceImpl(AltCourseRepo altCourseRepo,ModelMapper modelMapper) {
		this.altCourseRepo=altCourseRepo;
		this.modelMapper=modelMapper;
	}
	

	

	

}
