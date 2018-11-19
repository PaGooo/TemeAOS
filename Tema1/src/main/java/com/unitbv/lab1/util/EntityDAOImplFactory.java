package com.unitbv.lab1.util;

import com.unitbv.lab1.dao.*;

public class EntityDAOImplFactory {
	
	public static PersonDAO createNewPersonDAOImpl(String persistenceUnitName) {
		return new PersonDAO(persistenceUnitName);
	}
}