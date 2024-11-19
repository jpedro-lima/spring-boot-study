package com.studyspring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyspring.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
