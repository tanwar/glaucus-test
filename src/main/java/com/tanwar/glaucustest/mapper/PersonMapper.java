package com.tanwar.glaucustest.mapper;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.tanwar.glaucustest.domain.Person;
/**
 * Mapper class to map the person details.
 * @author Tanwar
 *
 */
@Component
public class PersonMapper {

	/**
	 * Method to map the personal details but name as name is the key in this example. 
	 * @param source
	 * @param target
	 */
	public void mapPerson(Person source, Person target) {
		target.setModifiedAt(LocalDateTime.now());
		target.setEmail(StringUtils.defaultIfEmpty(source.getEmail(), target.getEmail()));
		target.setPhonenumber(StringUtils.defaultIfEmpty(source.getPhonenumber(), target.getPhonenumber()));
	}

}
