package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	
	private static List<Person> DB = new ArrayList<Person>();
	
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	public List<Person> selectAllPeople() {
		return DB;
	}

	public Optional<Person> selectPersonById(UUID id) {
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}

	public int deletePerosnById(UUID id) {
		return 0;
	}

	public int updatePersonById(UUID id, Person person) {
		return 0;
	}
}