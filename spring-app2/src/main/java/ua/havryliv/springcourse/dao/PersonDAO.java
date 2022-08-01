package ua.havryliv.springcourse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.havryliv.springcourse.models.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;
	
	{
		people = new ArrayList<>();
		
		people.add(new Person(++PEOPLE_COUNT, "Tom", 19, "mail1@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Bob", 20, "mail2@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Mike", 21, "mail3@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Katy", 22, "mail4@gmail.com"));
	}
	
	public List<Person> index(){
		return people;
	}
	
	public Person show(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}
	
	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}
	
	public void update(int id, Person updatedPerson) {
		Person personToBeUpdated = show(id);
		
		personToBeUpdated.setName(updatedPerson.getName());
		personToBeUpdated.setAge(updatedPerson.getAge());
		personToBeUpdated.setEmail(updatedPerson.getEmail());
	}
	
	public void delete(int id) {
		people.removeIf(p -> p.getId() == id);
	}
}
