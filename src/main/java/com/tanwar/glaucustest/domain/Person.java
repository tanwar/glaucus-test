package com.tanwar.glaucustest.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Person node entity class with person attributes.
 * @author Tanwar
 *
 */
@NodeEntity
public class Person {

	@Id
	@NotEmpty
	private String name;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Size(min = 7, max = 14)
	private String phonenumber;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	@Relationship(type = "NEIGHBOUR", direction = Relationship.UNDIRECTED)
	public Set<Person> neighbours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void neighbour(Person person) {
		if (neighbours == null) {
			neighbours = new HashSet<>();
		}
		neighbours.add(person);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
