package com.higginbottom.mark.spring.mvc.dao;

import java.util.List;

import com.higginbottom.mark.spring.mvc.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPeople();
	public Person getPersonById(int id);
	public void removePerson(int id);
}
