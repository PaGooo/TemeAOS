package com.unitbv.Tema2.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unitbv.Tema2.dao.PersonDAO;

public class EntityDAOImplFactory {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testPU");

	public static PersonDAO createNewPersonDAOImpl(String persistenceUnitName) {
		return new PersonDAO(persistenceUnitName);
	}
}
