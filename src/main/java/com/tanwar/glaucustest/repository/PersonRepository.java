package com.tanwar.glaucustest.repository;

import org.springframework.data.repository.CrudRepository;

import com.tanwar.glaucustest.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}
