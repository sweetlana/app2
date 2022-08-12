package ua.havryliv.springcourse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ua.havryliv.springcourse.models.Person;

public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Person person = new Person();
		
		person.setId(resultSet.getInt("id"));
		person.setName(resultSet.getString("name"));
		person.setEmail(resultSet.getString("email"));
		person.setAge(resultSet.getInt("age"));
		
		return person;
	}

}
