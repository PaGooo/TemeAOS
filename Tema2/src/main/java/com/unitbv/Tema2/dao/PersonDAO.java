package com.unitbv.Tema2.dao;

import com.unitbv.Tema2.entities.Person;

public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO(String persistenceUnitName) {
		super(persistenceUnitName, Person.class);
	}
}
