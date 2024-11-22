package com.studyspring.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.studyspring.models.Person;
import com.studyspring.vo.PersonVO;

@Mapper
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class);

	Person voToPerson(PersonVO personVO);
	PersonVO personToVO(Person person);

	List<PersonVO> personListToVOList(List<Person> person);
	List<Person> personVOListToPersonList(List<PersonVO> personVO);
}
