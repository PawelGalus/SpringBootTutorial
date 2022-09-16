package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

	private final JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	public List<Person> selectAllPeople() {
		final String sql = "SELECT id, name FROM person";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String name = resultSet.getString("name");
			return new Person(id, name);
		});
	}

	public Optional<Person> selectPersonById(UUID id) {
		final String sql = "SELECT id, name FROM person WHERE id = ?";
		@SuppressWarnings("deprecation")
		Person person = jdbcTemplate.queryForObject(
				sql,
				new Object[]{id},
				(resultSet, i) -> {
					UUID personId = UUID.fromString(resultSet.getString("id"));
					String name = resultSet.getString("name");
					return new Person(personId, name);
				});
		
		return Optional.ofNullable(person);
	}

	public int deletePerosnById(UUID id) {
		return 0;
	}

	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

}
