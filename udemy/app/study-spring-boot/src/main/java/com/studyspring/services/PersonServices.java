package com.studyspring.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyspring.exceptions.ResourceNotFoundException;
import com.studyspring.models.Person;
import com.studyspring.repositorys.PersonRepository;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private static final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {
		logger.info("Finding all persons!");

		return personRepository.findAll();
	}

	public Person findById(Long id) {
		if (id == null)
			throw new ResourceNotFoundException("No records found for this ID");
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");

		return personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		if (person.getId() == null)
			throw new ResourceNotFoundException("No records found for this ID");

		logger.info("Updating one person!");

		Person entity = personRepository.findById(person.getId())
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

		Person entity = personRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		personRepository.delete(entity);
	}
}