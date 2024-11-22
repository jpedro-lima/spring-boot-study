package com.studyspring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyspring.exceptions.ResourceNotFoundException;
import com.studyspring.mapper.PersonMapper;
import com.studyspring.repositorys.PersonRepository;
import com.studyspring.vo.PersonVO;

@Service
public class PersonServices {
	private static final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository personRepository;

	PersonMapper personMapper = PersonMapper.INSTANCE;

	public List<PersonVO> findAll() {
		logger.info("Finding all persons!");

		return personMapper.personListToVOList(personRepository.findAll());
	}

	public PersonVO findById(Long id) {
		if (id == null)
			throw new ResourceNotFoundException("No records found for this ID");
		logger.info("Finding one person!");

		var entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return personMapper.personToVO(entity);
	}
	
	public PersonVO create(PersonVO personVO) {
		logger.info("Creating one person!");

		var entity = personMapper.voToPerson(personVO);
		return personMapper.personToVO(personRepository.save(entity));
	}
	
	public PersonVO update(PersonVO personVO) {
		logger.info("Updating one person!");

		var entity = personRepository.findById(personVO.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());

		return personMapper.personToVO(personRepository.save(entity));
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");

		var entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personRepository.delete(entity);
	}
}