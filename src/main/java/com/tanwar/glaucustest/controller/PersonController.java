package com.tanwar.glaucustest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanwar.glaucustest.domain.Person;
import com.tanwar.glaucustest.service.PersonService;

/**
 * PersonController to define the endpoints for operation on person entity.
 * @author Tanwar
 *
 */
@RestController
@RequestMapping("/")
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * GET mapping for pulling out the person details.
	 * @param name
	 * @return
	 */
	@GetMapping("persons/{name}")
	public Person getPersonDetails(@PathVariable String name) {
		return personService.getPersonDetails(name);
	}

	/**
	 * GET method to list all the persons. 
	 * @return
	 */
	@GetMapping("persons")
	public List<Person> getPersons() {
		return personService.getPersons();
	}

	/**
	 * PUT method to add a person.
	 * @param person
	 * @return
	 */
	@PutMapping("persons")
	public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
		Person savedPerson = personService.addPerson(person);
		return new ResponseEntity<Person>(savedPerson, HttpStatus.CREATED);
	}

	/**
	 * PATCH mapping to update person.
	 * @param person
	 * @return
	 */
	@PatchMapping("persons")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		Person savedPerson = personService.addPerson(person);
		return new ResponseEntity<Person>(savedPerson, HttpStatus.CREATED);
	}

	/**
	 * DELETE method to delete a person.
	 * @param name
	 * @return
	 */
	@DeleteMapping("persons/{name}")
	public ResponseEntity<Void> deletePerson(@PathVariable String name) {
		personService.deletePerson(name);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/**
	 * POST method to add connection between two persons as neighbours. 
	 * @param name
	 * @param neighbourName
	 * @return
	 */
	@PostMapping("persons/{name}/neighbour/{neighbour-person-name}")
	public ResponseEntity<Void> addNeighbour(@PathVariable String name,
			@PathVariable(name = "neighbour-person-name") String neighbourName) {
		personService.neighbours(name, neighbourName);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
