package com.studyspring.mapper;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapper {

	private static final MapperFacade mapper  = new DefaultMapperFactory.Builder().build().getMapperFacade();

	public static <O, D> D map(O origin, Class<D> destinationClass) {
		return mapper.map(origin, destinationClass);
	}

	public static <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationClass) {
		return mapper.mapAsList(sourceList, destinationClass);
	}
}