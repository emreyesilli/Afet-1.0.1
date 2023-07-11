package com.yardimcepte.afet.util.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {
	private final ModelMapper modelMapper;

	public ModelMapperService(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public ModelMapper forDto() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper;

	}

	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}
}
