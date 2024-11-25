package com.studyspring.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import com.studyspring.controllers.BookController;
import com.studyspring.exceptions.RequiredObjectIsNullException;
import com.studyspring.exceptions.ResourceNotFoundException;
import com.studyspring.mapper.BookMapper;
import com.studyspring.repositorys.BookRepository;
import com.studyspring.vo.BookVO;

@Service
public class BookServices {
	private static final Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository bookRepository;

	private final BookMapper bookMapper = BookMapper.INSTANCE;

	public List<BookVO> findAll() {
		logger.info("Finding all books!");

		var BooksList = bookMapper.bookListToVOList(bookRepository.findAll());

		for (var book : BooksList)
			book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		return BooksList;
	}

	public BookVO findById(Long id) {
		logger.info("Finding one book!");

		var entity = bookRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		var bookVO = bookMapper.bookToVO(entity);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

	public BookVO create(BookVO book) {
		logger.info("Creating one book!");
		if (book == null)
			throw new RequiredObjectIsNullException();

		var entity = bookMapper.voToBook(book); 

		var bookVO = bookMapper.bookToVO(bookRepository.save(entity));
		bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());

		return bookVO;
	}
	
	public BookVO update(BookVO book) {
		logger.info("Updating one book!");
		if (book == null)
			throw new RequiredObjectIsNullException();

		var entity = bookRepository.findById(book.getKey())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());

		var bookVO = bookMapper.bookToVO(bookRepository.save(entity));
		bookVO.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		
		return bookVO;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one book!");

		var entity = bookRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		bookRepository.delete(entity);
	}
}
