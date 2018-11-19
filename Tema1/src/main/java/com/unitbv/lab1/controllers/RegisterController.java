package com.unitbv.lab1.controllers;

import com.unitbv.lab1.dao.PersonDAO;
import com.unitbv.lab1.util.EntityDAOImplFactory;
import com.unitbv.lab1.entities.*;

public class RegisterController {

	private static PersonDAO personDAO = EntityDAOImplFactory.createNewPersonDAOImpl("lab1db");

	public static void setPersistenceUnitName(String persistenceUnitName) {
		personDAO = EntityDAOImplFactory.createNewPersonDAOImpl(persistenceUnitName);
	}

	public static void insertNewPerson(String name, String email) {
		Person person = new Person(name, email);
		personDAO.createOrUpdate(person);
	}
}
