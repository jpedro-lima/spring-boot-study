package com.studyspring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyspring.exceptions.ResourceNotFoundException;
import com.studyspring.repositorys.PersonRepository;
import com.studyspring.valueObjects.PersonVO;

@Service
public class PersonServices {
	private static final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository personRepository;

	public List<PersonVO> findAll() {
		logger.info("Finding all persons!");

		return personRepository.findAll();
	}

	public PersonVO findById(Long id) {
		if (id == null)
			throw new ResourceNotFoundException("No records found for this ID");
		logger.info("Finding one person!");

		return personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		return personRepository.save(person);
	}
	
	public PersonVO update(PersonVO person) {
		if (person.getId() == null)
			throw new ResourceNotFoundException("No records found for this ID");

		logger.info("Updating one person!");

		var entity = personRepository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		if (id == null)
			throw new ResourceNotFoundException("No records found for this ID");
		logger.info("Deleting one person!");

		PersonVO entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personRepository.delete(entity);
	}
}