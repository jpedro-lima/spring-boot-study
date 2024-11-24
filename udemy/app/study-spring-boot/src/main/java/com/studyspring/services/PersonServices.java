package com.studyspring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.studyspring.controllers.PersonController;
import com.studyspring.exceptions.RequiredObjectIsNullException;
import com.studyspring.exceptions.ResourceNotFoundException;
import com.studyspring.mapper.PersonMapper;
import com.studyspring.repositorys.PersonRepository;
import com.studyspring.vo.PersonVO;

@Service
public class PersonServices {
	private static final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public List<PersonVO> findAll() {
		logger.info("Finding all persons!");

		var personsList = personMapper.personListToVOList(personRepository.findAll());

		for (var person : personsList)
			person.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());

		return personsList;
	}

	public PersonVO findById(Long id) {
		logger.info("Finding one person!");

		var entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		var personVO = personMapper.personToVO(entity);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		if (person == null)
			throw new RequiredObjectIsNullException();

		var entity = personMapper.voToPerson(person); 

		var personVO = personMapper.personToVO(personRepository.save(entity));
		personVO.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());

		return personVO;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		if (person == null)
			throw new RequiredObjectIsNullException();

		var entity = personRepository.findById(person.getKey())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var personVO = personMapper.personToVO(personRepository.save(entity));
		personVO.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
		
		return personVO;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");

		var entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personRepository.delete(entity);
	}
}