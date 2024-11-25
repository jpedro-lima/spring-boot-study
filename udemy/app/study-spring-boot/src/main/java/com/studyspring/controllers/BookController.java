
package com.studyspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyspring.services.BookServices;
import com.studyspring.vo.BookVO;
import com.studyspring.vo.PersonVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Book Endpoints")
@RequestMapping("/api/v1/book")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@GetMapping(
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Find all Books recorded",
		tags = {"Book Endpoints"},
		responses = {
			@ApiResponse(responseCode = "200", description = "Success Books found",
					content = { 
						@Content(
							mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))),
						@Content(
							mediaType = "application/xml",
							array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))
					}),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			@ApiResponse(responseCode = "404", description = "Books not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
		})
	public List<BookVO> findAll() {
		return service.findAll();
	}

	@GetMapping(
			value = "/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public BookVO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Create a new book",
			tags = {"Book Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Book created",
						content = @Content(schema = @Schema(implementation = BookVO.class))),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}

	@PutMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update an existing book",
			tags = {"Book Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Book updated",
						content = @Content(schema = @Schema(implementation = BookVO.class))),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "404", description = "Book not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a book by ID",
			tags = {"Book Endpoint"},
			responses = {
				@ApiResponse(responseCode = "204", description = "Book deleted", content = @Content),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "404", description = "Book not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}