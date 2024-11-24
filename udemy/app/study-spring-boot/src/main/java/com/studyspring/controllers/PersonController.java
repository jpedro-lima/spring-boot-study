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

import com.studyspring.services.PersonServices;
import com.studyspring.vo.PersonVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Person Endpoints")
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Find all people recorded",
			tags = {"Person Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Success people found",
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
				@ApiResponse(responseCode = "404", description = "People not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@GetMapping(
			value = "/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
			@Operation(summary = "Find a person by ID",
			tags = {"Person Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Success person found",
						content = @Content(schema = @Schema(implementation = PersonVO.class))),
				@ApiResponse(responseCode = "200", description = "No content", content = @Content),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "404", description = "People not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
		public PersonVO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Create a new person",
			tags = {"Person Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Person created",
						content = @Content(schema = @Schema(implementation = PersonVO.class))),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}

	@PutMapping(
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Update an existing person",
			tags = {"Person Endpoint"},
			responses = {
				@ApiResponse(responseCode = "200", description = "Person updated",
						content = @Content(schema = @Schema(implementation = PersonVO.class))),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a person by ID",
			tags = {"Person Endpoint"},
			responses = {
				@ApiResponse(responseCode = "204", description = "Person deleted", content = @Content),
				@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
				@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
				@ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
				@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
			})
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}