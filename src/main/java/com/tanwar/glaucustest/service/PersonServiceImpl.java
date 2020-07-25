package com.tanwar.glaucustest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanwar.glaucustest.domain.Person;
import com.tanwar.glaucustest.exception.PersonNotFoundException;
import com.tanwar.glaucustest.mapper.PersonMapper;
import com.tanwar.glaucustest.repository.PersonRepository;

/**
 * PersonServiceImpl defines the implementation to behavior defined in PersonService.
 * @author Tanwar
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonMapper mapper;

	@Override
	public Person getPersonDetails(String name) {
		Optional<Person> personOptional = personRepository.findById(name);
		if (!personOptional.isPresent()) {
			throw new PersonNotFoundException(name + "not found");
		}

		return personOptional.get();
	}

	@Override
	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(person -> {
			persons.add(person);
		});
		return persons;
	}

	@Override
	public Person addPerson(Person person) {
		if (person.getCreatedAt() == null) {
			person.setCreatedAt(LocalDateTime.now());
		}
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(String name) {
		Optional<Person> personOptional = personRepository.findById(name);
		if (!personOptional.isPresent()) {
			throw new PersonNotFoundException(name + "not found");
		}
		personRepository.deleteById(name);

	}

	@Override
	public Person updatePerson(Person person) {
		Optional<Person> personOptional = personRepository.findById(person.getName());
		if(!personOptional.isPresent()) {
			throw new PersonNotFoundException(person.getName() + "not found");
		}
		Person existingPerson = personOptional.get();
		
		mapper.mapPerson(person, existingPerson);

		return personRepository.save(existingPerson);
	}

	@Override
	public void neighbours(String firstPersonName, String secondPersonName) {
		Optional<Person> firstPersonOptional = personRepository.findById(firstPersonName);
		if(!firstPersonOptional.isPresent()) {
			throw new PersonNotFoundException(firstPersonName + "not found");
		}
		
		Optional<Person> secondPersonOptional = personRepository.findById(secondPersonName);
		if(!secondPersonOptional.isPresent()) {
			throw new PersonNotFoundException(secondPersonName + "not found");
		}
		
		Person firstPerson = firstPersonOptional.get();
		Person secondPerson = secondPersonOptional.get();
		
		firstPerson.neighbour(secondPerson);
		personRepository.save(firstPerson);
	}

}
