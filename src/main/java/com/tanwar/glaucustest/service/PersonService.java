package com.tanwar.glaucustest.service;

import java.util.List;

import com.tanwar.glaucustest.domain.Person;

/**
 * PersonService defines the behavior for operation on the person.
 * @author Tanwar
 *
 */
public interface PersonService {

	/**
	 * Method to define the behavior for getting personal details.
	 * @param name
	 * @return
	 */
	Person getPersonDetails(String name);

	/**
	 * Method to return the list of all persons.
	 * @return
	 */
	List<Person> getPersons();

	/**
	 * Method to add a person.
	 * @param person
	 * @return
	 */
	Person addPerson(Person person);

	/**
	 * Method to delete a person.
	 * @param name
	 */
	void deletePerson(String name);

	/**
	 * Method to update person.
	 * @param person
	 * @return
	 */
	Person updatePerson(Person person);

	/**
	 * Method to establish a connection between two persons. 
	 * @param firstPerson
	 * @param secondPerson
	 */
	void neighbours(String firstPerson, String secondPerson);

}
