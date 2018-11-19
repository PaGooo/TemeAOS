package com.unitbv.lab1.dao;

import com.unitbv.lab1.dao.GenericDAO;
import com.unitbv.lab1.entities.Person;

public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO(String persistenceUnitName) {
		super(persistenceUnitName, Person.class);
	}
}