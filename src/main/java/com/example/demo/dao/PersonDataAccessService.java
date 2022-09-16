package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	public List<Person> selectAllPeople() {
		return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
	}

	public Optional<Person> selectPersonById(UUID id) {
		return Optional.empty();
	}

	public int deletePerosnById(UUID id) {
		return 0;
	}

	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

}
