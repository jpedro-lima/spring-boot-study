package com.studyspring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyspring.valueObjects.PersonVO;

public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
