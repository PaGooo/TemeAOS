package com.unitbv.lab1;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.unitbv.lab1.controllers.RegisterController;
import com.unitbv.lab1.dao.PersonDAO;
import com.unitbv.lab1.util.EntityDAOImplFactory;


public class RegisterTest {

	public static final String PERSISTANCE_UNIT_NAME = "lab1TestDB";
	private static PersonDAO personDAO;
	
	@BeforeClass
	public static void setUp() {
		personDAO = EntityDAOImplFactory.createNewPersonDAOImpl(PERSISTANCE_UNIT_NAME);
		RegisterController.setPersistenceUnitName(PERSISTANCE_UNIT_NAME);
	}
	
	@AfterClass
	public static void tearDown() {
		RegisterController.setPersistenceUnitName("lab1db");
	}
	
	@Test
	public void insertAPersonTest() {
		assertTrue(personDAO.readAll().isEmpty());

		RegisterController.insertNewPerson("testName", "testEmail");

		assertTrue(personDAO.readAll().size() == 1);

		RegisterController.insertNewPerson("testName2", "testEmail2");

		assertTrue(personDAO.readAll().size() == 2);
	}
}
