package com.studyspring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyspring.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
