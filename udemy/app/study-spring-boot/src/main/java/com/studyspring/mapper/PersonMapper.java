package com.studyspring.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.studyspring.models.Person;
import com.studyspring.vo.PersonVO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
	public PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class);
	
	@Mapping(source = "key", target = "id")
	Person voToPerson(PersonVO personVO);
	
	@Mapping(source = "id", target = "key")
	PersonVO personToVO(Person person);
	
	List<PersonVO>	personListToVOList(List<Person> person);
	List<Person>	voListToPersonList(List<PersonVO> personVO);
	
}
